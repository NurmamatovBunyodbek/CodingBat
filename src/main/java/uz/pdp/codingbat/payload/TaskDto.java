package uz.pdp.codingbat.payload;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.codingbat.entity.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String name;
    private Category category;
    private String question;
    private String template;
    private String answerText;
    private String solution;

}
