package com.hotelpms.controller;

import com.hotelpms.pojo.StoreRecords;
import com.hotelpms.service.Impl.StoreRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreRecordController {

    @Autowired
    private StoreRecordsServiceImpl storeRecordsService;

    //根据Id查询库存
    @GetMapping(value = "/queryStoreRecordsById")
    @ResponseBody
    public List<StoreRecords> queryStoreRecordsById(
            @RequestParam("id") String id
    ){
        List<StoreRecords> list = new ArrayList<>();
        list.add(storeRecordsService.queryStoreRecordsById(Integer.parseInt(id)));
        return list;
    }

    //新增一条库存记录
    @GetMapping(value = "/addStoreRecords")
    @ResponseBody
    public String addStoreRecords(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("amount") String amount,
            @RequestParam("price") String price
    ) {
        if (storeRecordsService.addStoreRecords(Integer.parseInt(id), name,
                Integer.parseInt(amount), new BigDecimal(price)))
            return "success";
        return "failed";
    }

    //更新一条库存记录
    @GetMapping(value = "/updateStoreRecords")
    @ResponseBody
    public String updateStoreRecords(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("amount") String amount,
            @RequestParam("price") String price
    ) {
        if (storeRecordsService.updateStoreRecords(Integer.parseInt(id), name,
                Integer.parseInt(amount), new BigDecimal(price)))
            return "success";
        return "failed";
    }

    //删除一条库存记录
    @GetMapping(value = "/deleteStoreRecords")
    @ResponseBody
    public String deleteStoreRecords(
            @RequestParam("id") String id
    ){
        if (storeRecordsService.deleteStoreRecords(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

    //展示库存列表
    @GetMapping(value = "/queryAllStoreRecords")
    @ResponseBody
    public List<StoreRecords> queryAllStoreRecords() {
        return storeRecordsService.queryAllStoreRecords();
    }

    //通过名字查询所有库存
    @RequestMapping(value = "/queryStoreRecordsByName")
    @ResponseBody
    public List<StoreRecords> queryStoreRecordsByName(
            @RequestParam("name") String name
    ) {
        List<StoreRecords> list = new ArrayList<>();
        list.add(storeRecordsService.queryStoreRecordsByName(name));
        return list;
    }
}
