package gxlg.model;

import java.util.Date;

public class Notice {
	
	private int id;
	private String title;
	private String author;
	private String content;
	private Date pubtime;
	
	public Notice() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPubTime() {
		return pubtime;
	}

	public void setPubTime(Date pubTime) {
		this.pubtime = pubTime;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + ", pubTime="
				+ pubtime + "]";
	}

	public Notice(int id, String title, String author, String content, Date pubTime) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.pubtime = pubTime;
	}

	public Notice(String title, String author, String content, Date pubTime) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.pubtime = pubTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((pubtime == null) ? 0 : pubtime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notice other = (Notice) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (pubtime == null) {
			if (other.pubtime != null)
				return false;
		} else if (!pubtime.equals(other.pubtime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	

}