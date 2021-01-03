package lk.EasyCarRental.backend.Service.Impl;

import lk.EasyCarRental.backend.Service.FileUploadService;
import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.dto.UserDTO;
import lk.EasyCarRental.backend.entity.Customer;
import lk.EasyCarRental.backend.entity.User;
import lk.EasyCarRental.backend.repo.CustomerRepo;
import lk.EasyCarRental.backend.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Transactional
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void uploadNicFile(MultipartFile multipartFile, CustomerDTO  dto) throws IOException {}




}
