package com.dbconn;

public class VolWork {
		private String mpublisher;
	    private String meventdesp;
	    private String mpradate;
	    private String mrealnum;
	    private String madvnum;

	    public VolWork(String publisher,String eventdesp,String pradate,String realnum,String advnum) {
	        mpublisher = publisher;
	        meventdesp = eventdesp;
	        mpradate = pradate;
	        mrealnum = realnum;
	        madvnum = advnum;
	    }

	    public String getpublisher() {
	        return mpublisher;
	    }

	    public void setpublisher(String mpublisher) {
	        this.mpublisher = mpublisher;
	    }

	    public String geteventdesp() {
	        return meventdesp;
	    }

	    public void seteventdesp(String meventdesp) {
	        this.meventdesp = meventdesp;
	    }

	    public String getpradate() {
	        return mpradate;
	    }

	    public void setpradate(String mpradate) {
	        this.mpradate = mpradate;
	    }

	    public String getrealnum() {
	        return mrealnum;
	    }

	    public void setrealnum(String mrealnum) {
	        this.mrealnum = mrealnum;
	    }

	    public String getadvnum() {
	        return madvnum;
	    }

	    public void setadvnum(String madvnum) {
	        this.madvnum = madvnum;
	    }

}
