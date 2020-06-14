import com.jin.Service.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
@Component
@RunWith(SpringRunner.class)
public class TopicTest {


    @Test
    public void topic(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        TopicSender topicSender = new TopicSender(rabbitTemplate);
        topicSender.send2();
    }

}
