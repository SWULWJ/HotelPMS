package com.hotelpms.mapper;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.pojo.TenantInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TenantInfoMapper {

    //新增一个房客信息
    @Insert("INSERT INTO tenant_info(name, gender, id_card) "
            +"VALUES(#{name}, #{gender}, #{idCard})")
    void addTenantInfo(TenantInfo tenantInfo);

    //通过id删除一个房客信息
    @Delete("DELETE FROM tenant_info WHERE id=#{id}")
    void deleteTenantInfo(int id);

    //更新一个房客信息
    @Update("UPDATE tenant_info "
            +"SET name=#{name}, gender=#{gender}, id_card=#{idCard}"
            +"WHERE id=#{id}")
    void updateTenantInfo(TenantInfo tenantInfo);

    //通过id查找一个房客信息
    @Select("SELECT * FROM tenant_info WHERE id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "id_card", property = "idCard")
    })
    TenantInfo queryById(int id);

    //通过房客姓名称查找一个房客信息
    @Select("SELECT * FROM tenant_info WHERE name=#{name}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "id_card", property = "idCard")
    })
    List<TenantInfo> queryByName(String name);

    //查找所有房客信息
    @Select("SELECT * FROM tenant_info")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "id_card", property = "idCard")
    })
    List<TenantInfo> queryAll();

    //通过身份证号查询房客信息
    List<TenantInfo> queryTenantInfoByIdCard(String idCard);
}
