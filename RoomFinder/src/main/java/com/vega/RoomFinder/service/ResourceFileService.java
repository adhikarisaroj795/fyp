package com.vega.RoomFinder.service;

import com.vega.RoomFinder.model.ResourceFile;
import com.vega.RoomFinder.utils.FileType;
import org.springframework.web.multipart.MultipartFile;

public interface ResourceFileService {

    ResourceFile addFile (MultipartFile multipartFile, FileType fileType);

    ResourceFile findById(int id);
}
