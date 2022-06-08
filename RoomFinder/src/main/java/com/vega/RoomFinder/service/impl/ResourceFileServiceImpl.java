package com.vega.RoomFinder.service.impl;

import com.vega.RoomFinder.model.ResourceFile;
import com.vega.RoomFinder.repository.ResourceFileRepository;
import com.vega.RoomFinder.service.ResourceFileService;
import com.vega.RoomFinder.utils.Constants;
import com.vega.RoomFinder.utils.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

@Service
public class ResourceFileServiceImpl implements ResourceFileService {

    @Autowired
    private ResourceFileRepository resourceFileRepository;

    @Override
    public ResourceFile addFile(MultipartFile multipartFile, FileType fileType)
    {
        String orginalFilename = multipartFile.getOriginalFilename();

        String filename = getFilename(orginalFilename);
        String filePath = Constants.FILE_PATH + filename;
        try
        {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        ResourceFile resourceFile = new ResourceFile(orginalFilename, filePath, fileType);

        return resourceFileRepository.save(resourceFile);
    }
    private String getFilename(String orginalFilename)
    {
        long currentEpoch = Instant.now().toEpochMilli();
        return String.valueOf(currentEpoch).concat(".").concat(getExtention(orginalFilename));
    }

    @Override
    public ResourceFile findById(int id)
    {
        return null;
    }
    private String getExtention(String filename)
    {
        int i = filename.lastIndexOf('.');
        return filename.substring(i+1);
    }
}
