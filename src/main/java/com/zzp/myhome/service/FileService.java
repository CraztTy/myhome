package com.zzp.myhome.service;

import com.github.pagehelper.PageInfo;
import com.zzp.myhome.entity.FileEntity;
import org.springframework.stereotype.Service;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
public interface FileService {

    void insert(FileEntity fileEntity);

    PageInfo<FileEntity> selectAll(int pageNum, int pageSize);
}
