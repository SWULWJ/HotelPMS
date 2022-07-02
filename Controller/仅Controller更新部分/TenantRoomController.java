package com.hotelpms.controller;

import com.hotelpms.pojo.TenantRoom;
import com.hotelpms.service.Impl.TenantRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class TenantRoomController {

    @Autowired
    TenantRoomServiceImpl tenantRoomService;

    @RequestMapping(value = "/addTenantRoom",method = RequestMethod.GET)
    @ResponseBody
    public String addTenantRoom(
            @RequestParam("id") int id,
            @RequestParam("tenant_id") int tenant_id ,
            @RequestParam("room_id") int room_id ){
        if(tenantRoomService.addTenantRoom(id, tenant_id, room_id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/updateTenantRoom",method = RequestMethod.GET)
    @ResponseBody
    public String updateTenantRoom(
            @RequestParam("id") int id,
            @RequestParam("tenant_id") int tenant_id ,
            @RequestParam("room_id") int room_id ){
        if(tenantRoomService.updateTenantRoom(id, tenant_id, room_id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/deleteTenantRoom",method = RequestMethod.GET)
    @ResponseBody
    public String deleteTenantRoom(@RequestParam("id") int id){
        if(tenantRoomService.deleteTenantRoom(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/queryTenantRoomById",method = RequestMethod.GET)
    @ResponseBody
    public TenantRoom queryTenantRoomById(@RequestParam("id") int id){
        return tenantRoomService.queryTenantRoomById(id);
    }

    @RequestMapping(value = "/queryTenantRoomByTenantId",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantRoom> queryTenantRoomByTenantId(@RequestParam("tenant_id") int tenant_id){
        return tenantRoomService.queryTenantRoomByTenantId(tenant_id);
    }

    @RequestMapping(value = "/queryAllTenantRoom",method = RequestMethod.GET)
    @ResponseBody
    public List<TenantRoom> queryAllTenantRoom(){
        return tenantRoomService.queryAllTenantRoom();
    }

}
