package com.hotelpms.controller;

import com.hotelpms.pojo.StoreRecords;
import com.hotelpms.service.Impl.StoreRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreRecordController {

    @Autowired
    private StoreRecordsServiceImpl storeRecordsService;

//    @RequestMapping(value = "/addStoreRecords",method = RequestMethod.GET)
//    @ResponseBody
//    public String addStoreRecords(
//            @RequestParam("id") int id,
//            @RequestParam("name") String name,
//            @RequestParam("amount") int amount,
//            @RequestParam("price") BigDecimal price
//    ){
//        if (storeRecordsService.addStoreRecords(id, name, amount, price))
//            return "success";
//        return "failed";
//    }

    // 添加一条记录
    // 输入: id,name,amount,price
    // 输出: success or failed
    @RequestMapping(value = "/addStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public String addStoreRecords(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("amount") String amount,
            @RequestParam("price") String price
    ){
        if (storeRecordsService.addStoreRecords(Integer.parseInt(id), name,
                Integer.parseInt(amount), new BigDecimal(price)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/updateStoreRecords",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateStoreRecords(
//            @RequestParam("id") int id,
//            @RequestParam("name") String name,
//            @RequestParam("amount") int amount,
//            @RequestParam("price") BigDecimal price
//    ){
//        if (storeRecordsService.updateStoreRecords(id, name, amount, price))
//            return "success";
//        return "failed";
//    }

    // 更新一条记录
    // 输入: id,name,amount,price
    // 输出: success or failed
    @RequestMapping(value = "/updateStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public String updateStoreRecords(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("amount") String amount,
            @RequestParam("price") String price
    ){
        if (storeRecordsService.updateStoreRecords(Integer.parseInt(id), name,
                Integer.parseInt(amount), new BigDecimal(price)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/deleteStoreRecords",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteStoreRecords(
//            @RequestParam("id") int id
//    ){
//        if (storeRecordsService.deleteStoreRecords(id))
//            return "success";
//        return "failed";
//    }

    // 删除一条记录
    // 输入: id
    // 输出: success or failed
    @RequestMapping(value = "/deleteStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public String deleteStoreRecords(
            @RequestParam("id") String id
    ){
        if (storeRecordsService.deleteStoreRecords(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/queryStoreRecords",method = RequestMethod.GET)
//    @ResponseBody
//    public StoreRecords queryStoreRecords(
//            @RequestParam("id") int id
//    ){
//        return storeRecordsService.queryStoreRecords(id);
//    }

    // 根据 id 查询一条记录
    // 输入: id
    // 输出: List<StoreRecords>
    @RequestMapping(value = "/queryStoreRecordsById",method = RequestMethod.GET)
    @ResponseBody
    public List<StoreRecords> queryStoreRecordsById(
            @RequestParam("id") String id
    ){
        List<StoreRecords> list = new ArrayList<>();
        list.add(storeRecordsService.queryStoreRecordsById(Integer.parseInt(id)));
        return list;
    }


    // 根据 name 查询一条记录
    // 输入: name
    // 输出: List<StoreRecords>
    @RequestMapping(value = "/queryStoreRecordsByName",method = RequestMethod.GET)
    @ResponseBody
    public List<StoreRecords> queryStoreRecordsByName(
            @RequestParam("name") String name
    ){
        List<StoreRecords> list = new ArrayList<>();
        list.add(storeRecordsService.queryStoreRecordsByName(name));
        return list;
    }


    // 根据 查询所有记录
    // 输入: 无
    // 输出: List<StoreRecords>
    @RequestMapping(value = "/queryAllStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public List<StoreRecords> queryAllStoreRecords(){
        return storeRecordsService.queryAllStoreRecords();
    }
}
