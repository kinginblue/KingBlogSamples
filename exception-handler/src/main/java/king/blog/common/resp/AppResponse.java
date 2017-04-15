package king.blog.common.resp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * APP端返回信息协议实体
 */
public class AppResponse extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应代码
	 */
	private static final String CODE = "code";

	/**
	 * 响应消息提示
	 */
	private static final String INFO = "info";

	/**
	 * 响应数据域
	 */
	private static final String DATA = "data";
	
	/**
	 * 响应分页总页数
	 */
	private static final String NEXT_TAG = "next";

	/**
	 * 响应分页当前数据列表
	 */
	private static final String PAGE_LIST_TAG = "list";

	/**
	 * 响应分页分页总数据行数
	 */
	private static final String TOTAL_COUNT_TAG = "total";

	/** 默认构造方法：默认设置返回成功 **/
	public AppResponse() {
		super();
		this.put(CODE, StatCode.SUCCESS);
		this.put(INFO, "");
		this.put(DATA, new Object());
	}

	public void setFail() {
		this.put(CODE, StatCode.FAILURE);
	}
	public void setFail(String info) {
		this.put(CODE, StatCode.FAILURE);
		this.put(INFO, info);
	}
	public void setFail(String info, Object data) {
		this.put(CODE, StatCode.FAILURE);
		this.put(INFO, info);
		this.put(DATA, data);
	}

	/**
	 * 强制客户端重新登录
	 * @param warm 警告信息
     */
	public void forceReLogin(String warm){
		this.put(CODE, StatCode.FORCE_RE_LOGIN);
		this.put(INFO, warm);
	}

	public void setInfo(String info) {
		this.put(INFO, info);
	}

	public void setData(Object data) {
		this.put(DATA, data);
	}

	public <T> void setData(List<T> list) {
		Map<String, Object> map = new HashMap<>();
		map.put(NEXT_TAG, 0);
		map.put(PAGE_LIST_TAG, list);
		map.put(TOTAL_COUNT_TAG, list.size());
		setData(map);
	}

	/** 响应状态码 **/
	private static class StatCode {
		/** 成功 */
		static final int SUCCESS = 0;
		/** 失败 */
		static final int FAILURE = -1;
		/** 信息过期，强制重新登录 */
		static final int FORCE_RE_LOGIN = -2;
	}

	/** 分页状态码 **/
	private static class PagerCode{
		/** 分页：还有下一页 **/
		static final int HAS_NEXT = 1;
		/** 分页：没有下一页 **/
		static final int NO_NEXT = 0;
	}

}
