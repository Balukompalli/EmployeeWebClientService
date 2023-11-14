package com.employee.webclient.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EmployeeRequest {
    private Long employeeId;
    private String employeeName;
    private String departmentName;
    private Long salary;

}
