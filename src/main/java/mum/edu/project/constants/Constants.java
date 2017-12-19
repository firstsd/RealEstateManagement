package mum.edu.project.constants;

public class Constants {
	public final class PROPERTY {

		public final class PURPOSE_TYPE {

			public static final String SELL = "Sell";

			public static final String RENT = "Rent";
		}

		public final class LIST {

			public static final int PAGER_COUNT = 12;

		}

		public final class STATUS {
			

			public static final int PENDING = 1;

			public static final int APPROVED = 2;

			public static final int SOLD = 3;

			public static final int RENTED = 4;

			public static final int CANCELLED = 5;

			public static final int DELETED = 6;

		}

		public final class TYPE {

			public static final int HOUSE = 1;

			public static final int APARTMENT = 2;

		}
	}

	public final class ROLE {

		public static final int ROLE_BUYER = 1;

		public static final int ROLE_SELLER = 2;

		public static final int ROLE_AGENT = 3;

		public static final int ROLE_ADMIN = 4;
	}

	public final class ORDER {

		public final class TYPE {

			public static final String BUY = "Buy";

			public static final String RENT = "Rent";
		}

		public final class LIST {

			public static final int PAGER_COUNT = 12;

		}

		public final class STATUS {

			public static final int PENDING = 1;

			public static final int APPROVED = 2;

			public static final int BOUGHT = 3;

			public static final int RENTED = 4;

			public static final int CANCELLED = 5;

			public static final int DELETED = 6;

		}

	}

	public final class INVOICE {

		public final class STATUS {

			public static final int PENDING = 1;

			public static final int PAID = 2;

		}

	}
}
