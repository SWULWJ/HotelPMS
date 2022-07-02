package com.hotelpms.controller;

import com.hotelpms.pojo.StoreRecords;
import com.hotelpms.service.Impl.StoreRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

public class StoreRecordController {

    @Autowired
    private StoreRecordsServiceImpl storeRecordsService;

    @RequestMapping(value = "/AddStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public String addStoreRecords(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("amount") int amount,
            @RequestParam("price") BigDecimal price
    ){
        if (storeRecordsService.addStoreRecords(id, name, amount, price))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/UpdateStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public String updateStoreRecords(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("amount") int amount,
            @RequestParam("price") BigDecimal price
    ){
        if (storeRecordsService.updateStoreRecords(id, name, amount, price))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/DeleteStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public String deleteStoreRecords(
            @RequestParam("id") int id
    ){
        if (storeRecordsService.deleteStoreRecords(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/QueryStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public StoreRecords queryStoreRecords(
            @RequestParam("id") int id
    ){
        return storeRecordsService.queryStoreRecords(id);
    }

    @RequestMapping(value = "/QueryStoreRecords",method = RequestMethod.GET)
    @ResponseBody
    public List<StoreRecords> queryAllStoreRecords(){
        return storeRecordsService.queryAllStoreRecords();
    }

}
