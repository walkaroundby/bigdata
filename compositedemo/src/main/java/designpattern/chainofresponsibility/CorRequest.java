package designpattern.chainofresponsibility;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description:
 *
 * @author luowei
 * @date 2019/11/18 21:00
 */
@Data
@AllArgsConstructor
public class CorRequest {
    private String requestType;

    private String requestContent;

    private int number;

}
