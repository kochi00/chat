package jp.ac.shibaura_it.infolab1.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
public class ChannelTest {
    Channels channels;
    ChannelOperation channelOperations;
    @BeforeEach
    void before() {
        channels = new Channels();
        channels.addChannel("test-channel", "test-description");
        channels.addChannel("test-channel2", "test-description2");
        channels.addChannel("test-channel3", "test-description3");
        channelOperations = new ChannelOperation();
    }
    @Test
    void test_channel() {
       channelOperations.Show(channels);
       channelOperations.Select(1, channels);
       assertThat(channels.channelList.get(0).name, is("test-channel"));
    }
    @Test
    void test_channel2() {
       channelOperations.Show(channels);
       assertThat(channelOperations.Select(4, channels), is(nullValue()));
    }
    @Test
    void test_channel3() {
       channels.addChannel("shibaura", "課題質問用チャンネル");
        channelOperations.Show(channels);
       assertThat((channels.channelList.get(3).name),is("shibaura"));
    }
    @Test
    void test_channel4() {
       channels.addChannel("shibaura", "課題質問用チャンネル");
       channels.addChannel("shibaura", "課題質問用チャンネル");
    }
}
