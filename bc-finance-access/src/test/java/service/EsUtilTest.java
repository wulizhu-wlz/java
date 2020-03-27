package service;


import com.ipaynow.bcfinance.BcFinanceApplication;
import com.ipaynow.bcfinance.enums.ChDataTypeEnum;
import com.ipaynow.bcfinance.enums.ChannelIdEnum;
import com.ipaynow.bcfinance.enums.IsExtLinkEnum;
import com.ipaynow.bcfinance.enums.StatusEnum;
import com.ipaynow.bcfinance.vo.EsDataVo;
import com.ipaynow.bcfinance.EsUtil;
import com.ipaynow.bcfinance.vo.ImportEsDataVo;
import org.apache.commons.lang3.time.DateUtils;
import org.elasticsearch.client.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author MLL
 * @title: EsUtilTest
 * @projectName marinabaysands
 * @description ES工具类测试
 * @date 2020/2/26 16:10
 */
@SpringBootTest(classes = BcFinanceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EsUtilTest {

    @Autowired
    private EsUtil esUtil;

    @Test
    public void isExistIndexTest() {

        Request request = new Request(HttpMethod.GET.name(), "marindata");

        boolean isExist = esUtil.checkIndexExist(request);

        System.out.println("result === " + isExist);

    }

    @Test
    public void insertOrUpdateOneTest() {
        EsDataVo esDataVo = new EsDataVo();
        esDataVo.setBizId(13);
        String[] categeries = {"test", "case", "is", "ignore"};
        esDataVo.setCategories(Arrays.asList(categeries));

        String[] tags = {"test", "case", "is", "ignore"};
        esDataVo.setTags(Arrays.asList(tags));

        esDataVo.setTitle("test insert 数据");
        esDataVo.setName("test insert 数据");
        esDataVo.setContent("测试一下数据导入功能");
        esDataVo.setDetail("测试一下数据导入功能 一直以来，为了优化本博客站内搜索效果和速度，我使用 bing 的 site: 站内搜索做为数据源，在服务端获取、解析、处理并缓存搜索结果，直接输出 HTML。这个方案唯一的问题是时效性难以保证，尽管我可以在发布和修改文章时主动告诉 bing，但它什么时候更新索引则完全不受我控制。\\n本着不折腾就浑身不自在的原则，我最终还是使用 Elasticsearch 搭建了自己的搜索服务。Elasticsearch 是一个基于 Lucene 构建的开源、分布式、RESTful 搜索引擎，很多大公司都在用，程序员的好伙伴 Github 的搜索也用的是它。本文记录我使用 Elasticsearch 搭建站内搜索的过程，目前支持中文分词、同义词、标题匹配优先等常见策略，可以点击这里体验。曼秀雷敦");
        esDataVo.setImgUrl("");
        esDataVo.setLinkUrl("");
        esDataVo.setChannel(ChannelIdEnum.HOMEPAGE);
        esDataVo.setChDataType(ChDataTypeEnum.HOMEPAGE);
        esDataVo.setIsExternalLink(IsExtLinkEnum.N);
        esDataVo.setStatus(StatusEnum.NORMAL);
        esDataVo.setParentContent("");
        esDataVo.setParentId(2);
        esDataVo.setParentLinkUrl("");
        esDataVo.setParentTitle("餐厅");
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        esDataVo.setBizCreatedTime(DateUtils.addMilliseconds(now, -10));
        esDataVo.setBizModifiedTime(null);
        //esDataVo.setCreatedTime(now);
        //esDataVo.setModifiedTime(null);
        ImportEsDataVo importEsDataVo = EsDataVo.getImportData(esDataVo);

        esUtil.insertOrUpdateOne("marindata" +
                "", importEsDataVo);
    }
}
