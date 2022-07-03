import com.github.javarushcommunity.jrtb.bot.JavarushTelegramBot;
import com.github.javarushcommunity.jrtb.service.SendBotMessageSarviceImpl;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBoxMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    JavarushTelegramBot javarushTelegramBot;

    @BeforeEach
    public void init() {
        sendBotMessageService = new SendBotMessageSarviceImpl(javarushTelegramBot);
        javarushTelegramBot = Mockito.mock(JavarushTelegramBot.class);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(javarushTelegramBot).execute(sendMessage);

    }

}
