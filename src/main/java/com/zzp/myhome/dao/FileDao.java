package com.zzp.myhome.dao;

import com.github.pagehelper.PageInfo;
import com.zzp.myhome.entity.FileEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
@Service("FileDao")
public interface FileDao {

    @Insert("INSERT INTO file(fileName, filePath) VALUES(#{fileName}, #{filePath})")
    void insert(@Param("fileName") String fileName, @Param("filePath") String filePath);

    @Select("SELECT id,filename,filepath,createtime FROM file")
    List<FileEntity> selectAll();
}
