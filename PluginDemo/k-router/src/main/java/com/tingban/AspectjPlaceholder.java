package com.tingban;


import org.aspectj.lang.annotation.Aspect;

/**
 * 该类只是用于AOP占位用的，如果主项目没有用到AOP，该类不可删除，因为会导致其他没有用AOP的渠道打包失败。
 * 如果后面主项目用到了AOP，该类可以删掉。
 * @author Donald Yan
 * @date 2019-05-31
 */
@Aspect
public class AspectjPlaceholder {
}
