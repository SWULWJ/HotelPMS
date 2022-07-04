package com.hotelpms.controller;

import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.service.Impl.TenantInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class TenantInfoController {

    @Autowired
    private TenantInfoServiceImpl tenantInfoService;

//    @RequestMapping(value = "/addTenantInfo",method = RequestMethod.GET)
//    @ResponseBody
//    public String addTenantInfo(
//            @RequestParam("id") int id,
//            @RequestParam("name") String name,
//            @RequestParam("gender") String gender,
//            @RequestParam("idCard") String id_card
//    ){
//        if(tenantInfoService.addTenantInfo(id, name, gender, id_card))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/addTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public String addTenantInfo(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("idCard") String id_card
    ){
        if(tenantInfoService.addTenantInfo(Integer.parseInt(id),
                name, gender, id_card))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/updateTenantInfo",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateTenantInfo(
//            @RequestParam("id") int id,
//            @RequestParam("name") String name,
//            @RequestParam("gender") String gender,
//            @RequestParam("id_card") String id_card
//    ){
//        if(tenantInfoService.updateTenantInfo(id, name, gender, id_card))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/updateTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public String updateTenantInfo(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("idCard") String id_card
    ){
        if(tenantInfoService.updateTenantInfo(Integer.parseInt(id),
                name, gender, id_card))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/deleteTenantInfo",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteTenantInfo(
//            @RequestParam("id") int id
//    ){
//        if(tenantInfoService.deleteTenantInfo(id))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/deleteTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public String deleteTenantInfo(
            @RequestParam("id") String id
    ){
        if(tenantInfoService.deleteTenantInfo(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/queryTenantInfoById",method = RequestMethod.GET)
//    @ResponseBody
//    public TenantInfo queryTenantInfoById(
//            @RequestParam("id") int id
//    ){
//        return tenantInfoService.queryTenantInfoById(id);
//    }

    @RequestMapping(value = "/queryTenantInfoById",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantInfo> queryTenantInfoById(
            @RequestParam("id") String id
    ){
        List<TenantInfo> list = new ArrayList<>();
        list.add(tenantInfoService.queryTenantInfoById(Integer.parseInt(id)));
        return list;
    }


    @RequestMapping(value = "/queryAllTenantInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantInfo> queryAllTenantInfo(){
        return tenantInfoService.queryAllTenantInfo();
    }
}
