package gxlg.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import gxlg.model.Notice;
import gxlg.service.IUserService;

public class NoticeAction extends ActionSupport{
	private static final long serialVersionUID = -4159947880372603934L;

	private List<Notice> noticeList = new ArrayList<Notice>();
	
	public List<Notice> getNoticeList(){
		return noticeList;
	}
	
	public void setNoticeList(List<Notice> noticeList){
		this.noticeList = noticeList;
	}
	
	private int nid;// 当前通知编号
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	public String getNotices(){
		//模拟从数据库中拿到数据
		Notice n1 = new Notice();
		n1.setId(1);
		n1.setTitle("关于作业通知");
		n1.setAuthor("flack");
		n1.setContent("今天的Java ee的作业是模拟通知栏");
		n1.setPubTime(new Date());
		noticeList.add(n1);
		
		Notice n2 = new Notice();
		n2.setId(2);
		n2.setTitle("关于调课通知");
		n2.setAuthor("flack");
		n2.setContent("因为清明放假问题，所以把4月6号的课调至4月8号");
		n2.setPubTime(new Date());
		noticeList.add(n2);
		
		Notice n3 = new Notice();
		n3.setId(3);
		n3.setTitle("关于放假通知");
		n3.setAuthor("flack");
		n3.setContent("清明放假时间从4月5号到4月7号，8号正常上课");
		n3.setPubTime(new Date());
		noticeList.add(n3);
		
		ActionContext context = ActionContext.getContext();	
		Map<String,Object> session = context.getSession();
		session.put("noticeList", noticeList);
		
		for(Notice n:noticeList){
			System.out.println(n.getId());
			System.out.println(n.getTitle());
		}
		
		
		return SUCCESS;
	}
	
	public String getDetail(){
		// 模拟从数据库中获取通知详情
	Notice n=new Notice();
		if(nid==1){
			n.setId(1);
			n.setTitle("关于作业通知");
			n.setAuthor("flack");
			n.setContent("今天的Java ee的作业是模拟通知栏");
			n.setPubTime(new Date());
		}
		else if (nid==2) {
			n.setId(2);
			n.setTitle("关于调课通知");
			n.setAuthor("flack");
			n.setContent("因为清明放假问题，所以把4月6号的课调至4月8号");
			n.setPubTime(new Date());
		}else {
			n.setId(3);
			n.setTitle("关于放假通知");
			n.setAuthor("flack");
			n.setContent("清明放假时间从4月5号到4月7号，8号正常上课");
			n.setPubTime(new Date());
		}
		// 第一步：通过静态方法ActionContext.getContext()
		//       获取Struts2自动创建的ActionContext对象
		ActionContext ctx=ActionContext.getContext();
		// 第二步：存储信息至Request中
		ctx.put("noticeDetail",n);
		return SUCCESS;
	}

	
}