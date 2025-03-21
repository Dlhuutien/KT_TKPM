package decoratorPattern;

//Mở rộng chức năng mượn sách
abstract class BorrowDecorator implements BookBorrow {
	protected BookBorrow decoratedBorrow;

	public BorrowDecorator(BookBorrow decoratedBorrow) {
		this.decoratedBorrow = decoratedBorrow;
	}

	@Override
	public void borrow() {
		decoratedBorrow.borrow();
	}
}

//Gia hạn thời gian mượn
class ExtendedBorrow extends BorrowDecorator {
	private int extraDays;

	public ExtendedBorrow(BookBorrow decoratedBorrow, int extraDays) {
		super(decoratedBorrow);
		this.extraDays = extraDays;
	}

	@Override
	public void borrow() {
		super.borrow();
		System.out.println("Thời gian mượn được gia hạn thêm " + extraDays + " ngày.");
	}
}

//Yêu cầu sách bản đặc biệt
class SpecialEditionBorrow extends BorrowDecorator {
	private String editionType;

	public SpecialEditionBorrow(BookBorrow decoratedBorrow, String editionType) {
		super(decoratedBorrow);
		this.editionType = editionType;
	}

	@Override
	public void borrow() {
		super.borrow();
		System.out.println("Phiên bản đặc biệt được yêu cầu: " + editionType);
	}
}
