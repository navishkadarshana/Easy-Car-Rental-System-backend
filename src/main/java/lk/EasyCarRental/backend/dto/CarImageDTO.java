package lk.EasyCarRental.backend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarImageDTO {
    private String car_image_id;
    private String car_image_path;
    private String car_id;

    public CarImageDTO(String car_image_path, String car_id) {
        this.car_image_path = car_image_path;
        this.car_id = car_id;
    }
}
