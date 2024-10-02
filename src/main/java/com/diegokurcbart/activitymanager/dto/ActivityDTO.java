package com.diegokurcbart.activitymanager.dto;

import com.diegokurcbart.activitymanager.model.Activity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {

    @NotNull(message = "Name is mandatory")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    @Size(max = 200, message = "Description must be less than 200 characters")
    @NotBlank
    private String description;

    @NotNull(message = "Maximum capacity is mandatory")
    @Min(value = 1, message = "The capacity must be at least 1")
    private Integer maxCapacity;



    //Constructors
    public ActivityDTO(Activity activity) {
        this.setName(activity.getName());
        this.setDescription(activity.getDescription());
        this.setMaxCapacity(activity.getMaxCapacity());
    }
}
