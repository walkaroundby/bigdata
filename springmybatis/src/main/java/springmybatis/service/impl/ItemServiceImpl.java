package springmybatis.service.impl;

import org.springframework.stereotype.Service;
import springmybatis.dao.BaseDao;
import springmybatis.domain.Item;
import springmybatis.service.ItemService;

import javax.annotation.Resource;

/**
 *
 */
@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Resource(name="itemDao")
    public void setDao(BaseDao<Item> dao) {
        super.setDao(dao);
    }
}