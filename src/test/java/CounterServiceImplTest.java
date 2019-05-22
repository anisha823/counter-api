import com.au.counter.model.CountWord;
import com.au.counter.service.CounterService;
import com.au.counter.service.CounterServiceImpl;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CounterServiceImplTest {

    @Test
    public void testGetWordCount_WhenParagraphEmpty() {
        CounterService counterService = new CounterServiceImpl();
        String paragraph = null;

        CountWord countWord = counterService.getWordCount(paragraph);
        Assert.assertNull(countWord);
    }

    @Test
    public void testGetWordCount_WhenNotNull(){
        CounterService counterService = new CounterServiceImpl();
        String paragraph;
        paragraph = "Smile a while and while you smile ,\nthere goes miles and miles of smiles";
        String count = "miles|2\n" +
                "smile|2\n" +
                "and|2\n" +
                "while|2\n" +
                "of|1\n" +
                "goes|1\n" +
                "there|1\n" +
                "a|1\n" +
                "you|1\n" +
                "smiles|1\n";

        counterService.getWordCount(paragraph);
        Assert.assertEquals(count, counterService.getWordCount(paragraph).toString());
    }

    @Test
    public void testGetWordCount_ForWordList(){
        CounterService counterService = new CounterServiceImpl();
        String paragraph;
        List<String> wordList = Arrays.asList("notice", "that");
        paragraph = "Notice a notice and you will notice that this notice is not worth noticing";
        String count = "notice|4\nthat|1\n";

        counterService.getWordCount(paragraph,wordList);
        Assert.assertEquals(count, counterService.getWordCount(paragraph,wordList).toString());
    }

}