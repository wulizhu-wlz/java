package service;

import com.alibaba.fastjson.JSONObject;

import com.ipaynow.bcfinance.BcFinanceApplication;
import com.ipaynow.bcfinance.enums.ChannelIdEnum;
import com.ipaynow.bcfinance.service.SearchFromEsService;
import com.ipaynow.bcfinance.vo.SearchPageVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author MLL
 * @title: SearchFromEsServiceTest
 * @projectName marinabaysands
 * @description ES搜索测试类
 * @date 2020/3/2 18:10
 */
@SpringBootTest(classes = BcFinanceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchFromEsServiceTest  {


    @Autowired
    private SearchFromEsService searchFromEsService;

    @Test
    public void searchTest() {

        SearchPageVo vo = searchFromEsService.search("菜系", 5, 0);
        System.out.println("=============" + JSONObject.toJSONString(vo));
    }


    @Test
    public void suggestTest() {

        List<String> suggestTest = searchFromEsService.suggest("化", 2);
        System.out.println("=============" + suggestTest);
    }

    @Test
    public void searchInChannelTest() {

        SearchPageVo vo = searchFromEsService.searchInChannel("料理", ChannelIdEnum.RESTAURANT, 10, 0);
        System.out.println("=============" + JSONObject.toJSONString(vo));
    }

    @Test
    public void searchInChannelTest2() {

        SearchPageVo vo = searchFromEsService.searchInChannel("料理", ChannelIdEnum.RESTAURANT, 10, 0, "咖啡厅", "下午茶");
        //SearchPageVo vo = searchFromEsService.searchInChannel("料理", ChannelIdEnum.RESTAURANT, 10, 0, "咖啡茶饮");
        System.out.println("=============" + JSONObject.toJSONString(vo));
    }
}
