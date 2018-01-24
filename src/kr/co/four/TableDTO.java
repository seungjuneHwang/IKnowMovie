package kr.co.four;

import java.io.Serializable;

public class TableDTO implements Serializable {

	private int no;
	private String nal;
	private int ticketSales;
	private int marketSalse;
	private int totalSalse;
	private int totalDiscount;
	private int netIncome;
	private String nal1;
	private String nal2;
	private int avgDay;
	private int avgMonth;
	private int avgYear;
	private int toDayTicketSalse;
	private int toDayMarketSalse;
	private int avgPeopleSalse;

	public TableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TableDTO(int no, String nal, int ticketSales, int marketSalse, int totalSalse, int totalDiscount,
			int netIncome, String nal1, String nal2, int avgDay, int avgMonth, int avgYear, int toDayTicketSalse,
			int toDayMarketSalse, int avgPeopleSalse) {
		super();
		this.no = no;
		this.nal = nal;
		this.ticketSales = ticketSales;
		this.marketSalse = marketSalse;
		this.totalSalse = totalSalse;
		this.totalDiscount = totalDiscount;
		this.netIncome = netIncome;
		this.nal1 = nal1;
		this.nal2 = nal2;
		this.avgDay = avgDay;
		this.avgMonth = avgMonth;
		this.avgYear = avgYear;
		this.toDayTicketSalse = toDayTicketSalse;
		this.toDayMarketSalse = toDayMarketSalse;
		this.avgPeopleSalse = avgPeopleSalse;
	}

	public int getAvgYear() {
		return avgYear;
	}

	public void setAvgYear(int avgYear) {
		this.avgYear = avgYear;
	}

	public int getToDayTicketSalse() {
		return toDayTicketSalse;
	}

	public void setToDayTicketSalse(int toDayTicketSalse) {
		this.toDayTicketSalse = toDayTicketSalse;
	}

	public int getToDayMarketSalse() {
		return toDayMarketSalse;
	}

	public void setToDayMarketSalse(int toDayMarketSalse) {
		this.toDayMarketSalse = toDayMarketSalse;
	}

	public int getAvgPeopleSalse() {
		return avgPeopleSalse;
	}

	public void setAvgPeopleSalse(int avgPeopleSalse) {
		this.avgPeopleSalse = avgPeopleSalse;
	}

	public int getAvgMonth() {
		return avgMonth;
	}

	public void setAvgMonth(int avgMonth) {
		this.avgMonth = avgMonth;
	}

	public int getAvgDay() {
		return avgDay;
	}

	public void setAvgDay(int avgDay) {
		this.avgDay = avgDay;
	}

	public String getNal1() {
		return nal1;
	}

	public void setNal1(String nal1) {
		this.nal1 = nal1;
	}

	public String getNal2() {
		return nal2;
	}

	public void setNal2(String nal2) {
		this.nal2 = nal2;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNal() {
		return nal;
	}

	public void setNal(String nal) {
		this.nal = nal;
	}

	public int getTicketSales() {
		return ticketSales;
	}

	public void setTicketSales(int ticketSales) {
		this.ticketSales = ticketSales;
	}

	public int getMarketSalse() {
		return marketSalse;
	}

	public void setMarketSalse(int marketSalse) {
		this.marketSalse = marketSalse;
	}

	public int getTotalSalse() {
		return totalSalse;
	}

	public void setTotalSalse(int totalSalse) {
		this.totalSalse = totalSalse;
	}

	public int getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(int totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public int getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(int netIncome) {
		this.netIncome = netIncome;
	}

	@Override
	public String toString() {
		return "TableDTO [no=" + no + ", nal=" + nal + ", ticketSales=" + ticketSales + ", marketSalse=" + marketSalse
				+ ", totalSalse=" + totalSalse + ", totalDiscount=" + totalDiscount + ", netIncome=" + netIncome
				+ ", nal1=" + nal1 + ", nal2=" + nal2 + ", avgDay=" + avgDay + ", avgMonth=" + avgMonth + ", avgYear="
				+ avgYear + ", toDayTicketSalse=" + toDayTicketSalse + ", toDayMarketSalse=" + toDayMarketSalse
				+ ", avgPeopleSalse=" + avgPeopleSalse + "]";
	}

}
