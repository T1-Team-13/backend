package t1.team13.achievements.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgressResult {
    private int current;
    private int required;
}
