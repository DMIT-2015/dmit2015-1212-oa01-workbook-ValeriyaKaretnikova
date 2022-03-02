package dmit2015.dto;


import lombok.Data;

@Data
public class JobsEntityDto {

    private String jobsId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;

}
