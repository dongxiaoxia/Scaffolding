package xyz.dongxiaoxia.common.filter;

import xyz.dongxiaoxia.common.utils.CacheUtils;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

/**
 * 页面高速缓存过滤器
 * Created in 2016/4/12 by Tong zhenke <br>
 */
public class PageCachingFilter extends SimplePageCachingFilter {

    @Override
    protected CacheManager getCacheManager() {
        return CacheUtils.getCacheManager();
    }

}
