package uz.pdp.codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedTaskDto {

    private Integer userId;
    private Integer taskId;
    private Boolean isCompleted;
    private String answerText;
    private Integer testCaseCount;


}
