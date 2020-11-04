package my.ibm.utils;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WatcherApi implements Watcher {

    private static final Logger logger = LoggerFactory.getLogger(WatcherApi.class);
    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("【Watcher监听事件】={}",watchedEvent.getState());
        logger.info("【监听路径为】={}",watchedEvent.getPath());
        logger.info("【监听的类型为】={}",watchedEvent.getType()); //  三种监听类型： 创建，删除，更新
    }
}
