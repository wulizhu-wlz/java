var gulp = require('gulp');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var concat = require('gulp-concat');
var minify = require('gulp-minify-css');
var connect = require('gulp-connect');
var proxy = require('http-proxy-middleware');
var plumber = require('gulp-plumber');
var runSequence = require('run-sequence'),
    rev = require('gulp-rev'),
    revCollector = require('gulp-rev-collector'),
    sass = require('gulp-sass');

//压缩CSS
gulp.task('scss', function(){
      gulp.src(['./style/css/min/*.css'])
          .pipe(concat('main.css'))
          .pipe(rename({suffix: '.min'}))
          .pipe(minify())
          .pipe(gulp.dest('./style/css'))
          .pipe(connect.reload())
  });
gulp.task('sassfile',function(){
    return gulp.src('./style/css/min/*.scss')
        .pipe(plumber())
        .pipe(sass())
        .pipe(gulp.dest( 'style/css/min' ) );
});
//压缩JS
gulp.task('scripts', function(){
    gulp.src('./style/js/min/*.js')
      .pipe(rename({suffix: '.min'}))
      .pipe(uglify())
      .pipe(gulp.dest('./style/js'))
      .pipe(connect.reload())
});
gulp.task('html', function(){
    gulp.src('./views/*.html')
        .pipe(connect.reload())
});
//任务区
gulp.task('run', function(){
     gulp.run('scripts','scss','watch','versions');
    // connect.server({
    //     livereload: true,
    //     port: 9191
    // })
});
gulp.task('run1', function(){
     gulp.run('scripts','scss','html','watch');
     connect.server({
         livereload: true,
         port: 9090,
         middleware: function(connect, opt) {
             return [
                 proxy('/api', {
                     target: 'http://192.168.4.121:9090',
                     changeOrigin:true
                 })
             ]
         }
     });
});
//雪碧图合成
gulp.task('sprites', function(){
  gulp.src('./images/sprite/*.png')
      .pipe(sprites({
           imgName: 'sprite.png',
           cssName: '../css/min/sprite.css',
           padding: 5,
           algorithm: 'binary-tree',
           cssTemplate:  function (data) {
                var arr=[];
                data.sprites.forEach(function (sprite) {
                     arr.push(".icon-"+sprite.name+
                          "{" +
                          "background-image: url('"+sprite.escaped_image+"');"+
                          " background-position: "+sprite.px.offset_x+" "+sprite.px.offset_y+";"+
                          " width:"+sprite.px.width+";"+
                          " height:"+sprite.px.height+";"+
                          "}\n");
                });
                return arr.join("");
           }
      }))
      .pipe(gulp.dest('./images'))
});

//watch
gulp.task('watch', function(){
     gulp.watch('style/js/*.js', ['scripts']);
     //scss 编译
     gulp.watch('style/css/min/*.scss',['sassfile']);
     gulp.watch('style/css/min/*.css', ['scss']);
     gulp.watch('views/*.html', ['html']);
     //版本信息进行控制
     gulp.watch(['directive/*.js','factory/*.js','controllers/controllers.js','filter/*.js','app/*.js','style/css/main.min.css'], ['versions']);
     //版本信息控制2
     gulp.watch(['controllers/*.js','controllers/**/*.js','views/*.html','views/**/*.html'], ['versions']);

});

//js生成文件hash编码并生成 rev-manifest.json文件名对照映射,'factory/*.js','controllers/controllers.js','filter/*.js','style/css/main.min.css'
gulp.task('revJs', function(){
    return gulp.src(['directive/*.js','factory/*.js','controllers/controllers.js','filter/*.js','app/*.js','style/css/main.min.css'])
        .pipe(rev())
        .pipe(rev.manifest())
        .pipe(gulp.dest('./'));
});

gulp.task('revJs1', function(){
    return gulp.src(['controllers/*.js','controllers/**/*.js','views/*.html','views/**/*.html'])
        .pipe(rev())
        .pipe(rev.manifest())
        .pipe(gulp.dest('./controllers'));
});

gulp.task('revHtml', function () {
    return gulp.src(['*.json', 'index.html'])
        .pipe(revCollector())
        .pipe(gulp.dest('./'));
});


gulp.task('revHtml1', function () {
    return gulp.src(['./controllers/*.json', './app/route.config.js'])
        .pipe(revCollector())
        .pipe(gulp.dest('./app'));
});
gulp.task('dev', function (done) {
    condition = false;
    runSequence(
        ['revJs','revJs1'],
        ['revHtml','revHtml1'],
        done);
});
gulp.task('versions', ['dev']);