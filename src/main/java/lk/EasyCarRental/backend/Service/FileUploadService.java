package lk.EasyCarRental.backend.Service;

import lk.EasyCarRental.backend.dto.CustomerDTO;
import lk.EasyCarRental.backend.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {

    void uploadNicFile(MultipartFile file, CustomerDTO customer) throws IOException;
}
