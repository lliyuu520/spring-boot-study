/**   
* @Title: AjaxResult.java
* @Package com.gemray.api.base.response 
* @Description: TODO(用一句话描述该文件做什么) 
* @author lvfajin  
* @date 2017年4月12日 下午3:22:55 
* @version V1.0   
*/
package com.liliangyu.study.quartz.response;

import lombok.Data;

/**
 * 
* @ClassName: AjaxResult
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author liliangyu
* @date 2017年8月29日  
*
 */
@Data
public class AjaxResult {
	private Integer errorCode;
	private String errorMessage;
	private  Object data;

	private AjaxResult() {
	}

	private  static AjaxResult newInstance(){
		return new AjaxResult();
	}

	/**
	 * 成功
	 * @return
	 */
	public static AjaxResult success(){
		AjaxResult ajaxResult = AjaxResult.newInstance();
		ajaxResult.setResult(AjaxResultEnum.SUCCESS);
		return ajaxResult;
	}
	/**
	 * 成功
	 * @return
	 */
	public static AjaxResult success(Object o){
		AjaxResult ajaxResult = AjaxResult.success();
		ajaxResult.setData(o);
		return ajaxResult;
	}

	/**
	 * 服务器异常
	 * @return
	 */
	public static AjaxResult serverExcetion(){
		AjaxResult ajaxResult = AjaxResult.newInstance();
		ajaxResult.setResult(AjaxResultEnum.SERVER_EXCEPTION);
		return ajaxResult;
	}

	/**
	 * 设置枚举
	 * @param result
	 * @return
	 */
	private  void setResult(AjaxResultEnum result){
		this.setErrorCode(result.getKey());
		this.setErrorMessage(result.getValue());
	}
}
