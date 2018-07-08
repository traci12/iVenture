package com.sirib.iventure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class iVentureDatabase {

	public static final String DATABASE_NAME = "iVentureDatabase";
	public static final int DATABASE_VERSION = 1;

	/*
	 * A Table for Pointer This will get show the town
	 */
	public static final String DATABASE_TABLE7 = "Pointer_table";
	public static final String KEY_POINTERID7 = "Pointer_id";
	public static final String KEY_POINTERNAME7 = "Pointer_name";

	/*
	 * A Table for Contacts
	 */
	public static final String DATABASE_TABLE1 = "Contact_table";
	public static final String KEY_ID1 = "Town";
	public static final String KEY_NAME1 = "Name";
	public static final String KEY_CONTACT1 = "Contact";

	/*
	 * A Table for Attractions
	 */
	public static final String DATABASE_TABLE2 = "Attraction_table";
	public static final String KEY_ID2 = "Town";
	public static final String KEY_NAME2 = "Name";
	public static final String KEY_DESCRIPTION2 = "Description";
	public static final String KEY_PICTURE2 = "Picture";

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			// Pointer Table
			db.execSQL("CREATE TABLE " + DATABASE_TABLE7 + " ("
					+ KEY_POINTERID7 + " INTEGER PRIMARY KEY AUTOINCREMENT,  "
					+ KEY_POINTERNAME7 + " TEXT NOT NULL);");
			// Initial Data
			db.execSQL("INSERT INTO " + DATABASE_TABLE7 + " ("
					+ KEY_POINTERNAME7 + ") VALUES ('Laoag')");

			// Contact Table
			db.execSQL("CREATE TABLE " + DATABASE_TABLE1 + " (" + KEY_ID1
					+ " TEXT NOT NULL, " + KEY_NAME1 + " TEXT NOT NULL, "
					+ KEY_CONTACT1 + " TEXT NOT NULL);");
			// Initial Data
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE1
					+ " ("
					+ KEY_ID1
					+ ", "
					+ KEY_NAME1
					+ ", "
					+ KEY_CONTACT1
					+ ") VALUES ('San Nicolas','Red Ribbon,Tribecca Coffee Shop,Casa Nicolas Cafe','781-3888,781-3199,781-3184')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE1
					+ " ("
					+ KEY_ID1
					+ ", "
					+ KEY_NAME1
					+ ", "
					+ KEY_CONTACT1
					+ ") VALUES ('Batac','Batac Food House,Batac Plaza Fastfood,Chowking,Pik-a-Bun','792-4152,792-3652,792-1888,792-3107')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE1
					+ " ("
					+ KEY_ID1
					+ ", "
					+ KEY_NAME1
					+ ", "
					+ KEY_CONTACT1
					+ ") VALUES ('Laoag','Fort Ilocandia Resort Hotel,Java Hotel,Palacio de Laoag Hotel,Rio Grande Resort','670-9001 to 15,770-5996,773-1842 / 773-1848,770-5458')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE1
					+ " ("
					+ KEY_ID1
					+ ", "
					+ KEY_NAME1
					+ ", "
					+ KEY_CONTACT1
					+ ") VALUES ('Currimao','Playa Tropical Resort,Currimao Green Nipa Resort,Kadilian Beach Resort,Pangil Beach Resort,Sitio Remedios,Subli-Subli Beach','91755700223,670-1203 / 670-1201,9214195596,676-1229,9204914,9193067337')");

			// Attraction Table
			db.execSQL("CREATE TABLE " + DATABASE_TABLE2 + " (" + KEY_ID2
					+ " TEXT NOT NULL, " + KEY_NAME2 + " TEXT NOT NULL, "
					+ KEY_DESCRIPTION2 + " TEXT NOT NULL, " + KEY_PICTURE2
					+ " TEXT NOT NULL);");
			// Initial Data
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Pagudpud','Saud White sand Beach,Patapat Viaduct,Paraiso Ni Anton,Bantay Abot Cave,Maira-ira cove or Blue Lagoon,Dos Hermanos Island','It is the most popular among the scenic spots of the municipality. It is located in Brgy. Saud and is approximately 2.5 kilometers away from the town proper. It is famous for as creamy white sand which frames the emerald water of the heart shaped bay.,It is a winding bridge found at the foot of the cliff of the North Cordillera Mountain Ranges. It is a viaduct connecting Barangay Balaoi and Barangay Pancian which is around 1.2 kilometers long. This bridge is often referred to as the French Riviera of the North. It is along this winding bridge where you can find the once upon a time enchanting Mabugabog Falls but now it already serves as one of the sources of power of the minihydri electric plant. It is only during the rainy days when it shows its splendor with its water dropping rhythmically to a precipice on the rocky shore of the sea below. While at the Middle you could take a look at the awesome view of the sea below and the verdant mountains at the other side which is 200 meters above the sea level. The bridge its surround it makes it really a breathtaking scenery to behold.,It is located in Matarongtong Pagudpud. The reverberating endlessly down pouring water create a rhapsody which invokes life to sightseers.,Bantay Abot Caves means a mountain with a hole. A hole was found at the middle of the mountain where the waves were free to flash into its walls just like an open shore until it was wrecked by an earthquake during the 80�fs. It is also called the underground sea for on top of the cave is a lustrous vegetative cover.,The prize of all beaches in Ilocos and possible on all Luzon is Miraira Point in the Malingay Cove or Blue Lagoon in Brgy. Balaoi Pagudpud. The spectacular white sand beach has nothing but a few simple shade sheds and many natural trees for shade. It is untouched wild beach that gives the feeling of being shipwrecked in paradise. With huge old growth trees that canopy the shoreline and wild vines that grow along some of the more permanent sand dunes there is so much beauty here that one sometimes needs to stop and catch her breath. The cove is a thirty minute walk off the National Highway.,Two identical mountains seated at the heart of Brgy. Balaoi and was believed that these were two brothers who were so loyal to each other that they transformed to these prominent mountains.','saudwhitesand,patapatviaduct,paraisonianton,abotcave,bluelagoon,doshermanosisland')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Bangui','Bangui Windmill (North Wind Power Plant)','It is a 24.75 MW power generation plant consisting of 15 UNITS Vestas NM82 wind turbines rated at 1.65 MW each. The turbines are on shore and arranged in a single row spaced approximately 326 meters apart. All 15 wind turbines are connected to the Luzon grid and as of 1 of May 7 of 2005 all 15 wind turbines had delivered power to the Ilocos Norte Electric Cooperative (INEC) via TransCo Laoag. This project is the first power plant in the Philippines and Southeast Asia.','windmills')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Burgos','Cape Bojeador Lighthouse,Capurpuraoan Rock Which Means �gWhite Rock�h,Dragon Fruit Farm,Kangrian Falls','It is a concrete structure about 120 feet in height situated on top of a mountain. It was built in 1892 and was first lighted on March 31 of the same year when it send signal to ship passing by the Cape facing the northern portion of the South China Sea. Apparently this structure was built without steel during the Spanish regime making it a wonder in its engineering and architectural design. Tit this day the lighthouse is still being utilized by ships navigating in the South China Sea.,After just one visit this place will stand out in your mind as a natural wonder. It is a massive rock that juts put out into a sea. From afar it looks as if someone has wiped off the top layer frosting and exposed the cake that lies beneath. Up close it is a dazzling bright white rock that sparkles in the sun. Capurpuraoan is a showcase for the power of wind and water on rock and coral. Amzing!,A well-known dragon fruit farm that has a reputation of producing particularly sweet fruit in comparison to its competitors.,Located in Barangay Paaya is a 5 kilometer drive from the National Highway to the head of the trail. From there is a 4 kilometer hike to the falls. The first 20 minutes of the trial is out in the open and quite hot so remember to bring hat. The locals bring their cattle caribou horses and other animals to grace in these open fields. This treeless area provides a nice view of the surrounding hills limestone outcroppings and the area of the hike. When you settle down into the shade cover you will be grateful for the coolness. Along the trail you can search deer or identify the many types of plant life including many varieties of wild mushrooms. The waterfalls at Kaangrian are everywhere creating a semi-circle of water cascading down multiple layers of rock. The beauty of the area was created by limestone deposits which have created hundreds of small sparkling pools around the base of the falls.','lighthouse,kapurpurawan,dragonfruitfarm,kaangrianfalls')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Bacarra','Bacarra Domeless Tower','It is a 50 meter tower and was built in 1830 but was damaged in 1931 due to an earthquake. Another strong earthquake (7.8 intensity) in 1983 caused its dome totally down thus gaining the romanticized title Dignified Domeless Belltower in Asia.','tower')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Badoc','Juan Luna Museum','The restored house is now a repository of the memorabilia and reproductions of the works of the painter Juan Luna who furthered the cause of the Philippine Nationalism through his art earning the respect and admiration of the Europeans in recognition of his talent.','juanlunashrine')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Batac','Marcos Museum,Marcos Mausoleum,Aglipay Shrine,Gen. Artemio Ricarte Park','The ancestral house of the Marcoses in Batac showcases the memorabilia of the late Pres. Marcos.,It houses the remains of the late President Ferdinand R. Marcos laid in a refrigerated crypt. His remains have been lying here since September 1993.,It was built in memory of the patriot-priest Gregorio Aglipay founder of the Iglesia Filipina Independiente in 1902. The church was founded at the end of the Filipino-American war with its focus upon liberty on religious and political and social terms. His remains are interred here.,Built in honor of Gen. Artemio Ricarte the last Filipino general to surrender to the American troops whose half of his remains interred here and the other half was interred in Libingan ng mga Bayani in Manila.','marcosmuseum,marcosmausoleum,aglipayshrine,artemioricarte')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Laoag','Laoag Sinking Bell Tower,St. Williams Cathedral,Tobacco Monopoly Monument,Ilocos Norte Museum,Fort Ilocandia Resort and Casino,Laoag International Airport,Plaza Del Norte Hotel and Ilocos Norte Convention Center,La Paz Sand Dunes','This 45 meter high bell tower is one of the tallest built in the country. A landmark in the city�fs skyline the bell tower was constructed by the Augustinian Fathers several hundred years ago. The sinking tower is unique landmark of Spanish occupation in the Philippines When the tower was new a man on horseback could pass through its door. Today a man of ordinary height could hardly pass without stopping. What strikes many observers is the peculiarity of its distance from the church. The distance from the church is 85 meters a rare position among church edifices.,One of the biggest cathedrals on the country and it is the seat of the Diocese of Laoag. The construction of the cathedral began in 1612 and was the site of the Diocesan Congress in 1932 and 1949. The Augustinians built the church of Italian Renaissance design in 1612. Its unique 2 storey facade is held by 4 pairs of coupled columns. The deeply recessed niche shows the image of the Patron Saint of Laoag- San Guillermo.,The monument was constructed in 1882 at the foot of the Marcos Bridge to serve as a memorial to the lifting of the Tobacco Monopoly in 1881. It is a gesture of thanksgiving to the Spanish King Alfonso XIII for having lifted the tobacco monopoly which from 1872 to 1881 gave the Ilocanos untold miseries as they were obliged to plant tobacco to be delivered solely to the government.,Showcases the varied ethnicity and multifaceted cultural heritage of a sturdy and hardworking people known for their industry and resourcefulness and loyalty.,It is the only first class/ deluxe hotel in the Northern Philippines. The hotel is sprawled over 77 hectares of land amidst gentle sand dunes and pine forest and 2 kilometers of fine sandy beach facing the South China Sea. The hotel is situated on the northwestern tip of Luzon Island in the province of Ilocos Norte. Laoag City and the Laoag International Airport are a short 10 minute drive from the hotel. Fort Ilocandia was conceived in 1980 and opens its doors in 1983. The complexes consist of the five Spanish colonial buildings and are finished in cool red bricks inspired by the Spanish Mediterranean designs of Marrakech Morocco.It is the only first class/ deluxe hotel in the Northern Philippines. The hotel is sprawled over 77 hectares of land amidst gentle sand dunes and pine forest and 2 kilometers of fine sandy beach facing the South China Sea. The hotel is situated on the northwestern tip of Luzon Island in the province of Ilocos Norte. Laoag City and the Laoag International Airport are a short 10 minute drive from the hotel. Fort Ilocandia was conceived in 1980 and opens its doors in 1983. The complexes consist of the five Spanish colonial buildings and are finished in cool red bricks inspired by the Spanish Mediterranean designs of Marrakech Morocco.,It caters to international flights	direct from Kaoshiung and Taipei Taiwan and Guangzhou China and Hongkong and connecting flights from Honolulu Los Angeles and San Francisco and Las Vegas and Vancouver.,It is a great ad neat place for lodging. It can hold conventions and gatherings where around 1500 people can be accommodated.,La Paz Sand Dunes offers a spectacular vista of the South China Sea. It is located in Brgy. La Paz Laoag City which has been declared as National Geological Monument. It covers an area of 85 square kilometers and is declared and protected as a geological monument because of its unique land formation. La Paz is a favorite shooting location for locals as well as international films.','sinkingbelltower,williamscathedral,tobaccomonopoly,ilocosmuseum,fortilocandia,internationalairport,plazadelnorte,lapazsanddunes')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Paoay','Paoay Lake National Park,Paoay Golf Course,Malacanang of the North,Paoay Church/ St. Augustine Church (UNESCO World Heritage Site)','The landlocked lake located 3kms away from the sea in Suba Paoay has an area of more or less 478 hectares. Declared as National Park under Republic Act 5631 on June 21 of 1969. Known in early days as Nangguyudan. Legend has it that a village lies beneath Paoay lake�fs still waters. The lost village was reputedly people by affluent families that refuses to aid a needy beggar. As punishment torrents of rain began pouring over the village. Floods water rapidly rose until the village was submerged and Paoay Lake was formed. It is said that fishers sometimes catch fish wearing gold rings a testament to the extravagant lifestyle of the people who lived in the submerged village. Geological studies indicate however that the 400 hectare lake was formed by a massive earthquake that caused the ground to sink and be filled with water from underground springs.,The complex has an 18-holegolf course and has other facilities and amenities. It has a land area of 77 hectares ad designed by Gary Player.,It was built as the official residence of the late Pres. Marcos in Ilocos Norte overlooking the Legendary Paoay Lake; this imposing structure is now a museo.,Built of Coral blocks and stucco plastered bricks the architecture is unique combination of Gothic and Baroque and Oriental. Construction of the Church was started in 1704 and completed in 1894. A few meters away is the coral-stone bell tower which served as observation post of the Katipuneros during the Philippine Revolution again by the Guerillas during the Japanese occupation. In 1992 the church is nominated to the UNESCO�fs World Heritage List and officially inscribed in 1993.','paoaylake,paoaygolfcourse,malacanang,paoaychurch')");
			db.execSQL("INSERT INTO "
					+ DATABASE_TABLE2
					+ " ("
					+ KEY_ID2
					+ ", "
					+ KEY_NAME2
					+ ", "
					+ KEY_DESCRIPTION2
					+ ", "
					+ KEY_PICTURE2
					+ ") VALUES ('Currimao','Currimao Green Nipa Beach Resort,Moro Watch Tower,Pangil Coral Rock Formation,Sitio Remedios Resort','It is a class AAA resort in Ilocos Norte.  The resort is complete with facilities and luxurious rooms which provide satisfaction to tourist both foreign and local; and travelers. It is equipped with 100 rooms. Each guest can engage in the luxury of gym and sauna and swimming pool and other water sports activities and horse riding.,This tower holds a very significant historical account about the Municipality of Currimao.,It is a place where tourist can see a breathtaking view and experience a one of a kind encounter with the sea life near the coral rock formations.,It is a unique and perfect gateway place for people looking forward to experience life in the province wherein the cottages or houses are named after different municipalities found in the region and are reflective of their place.',' ,morowatchtower,pangil,sitioremedios')");

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
			onCreate(db);
		}

	}

	public iVentureDatabase(Context c) {
		ourContext = c;
	}

	public iVentureDatabase open() throws SQLException {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		ourHelper.close();
	}

	public List<String> getContact(String num) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ID1, KEY_NAME1, KEY_CONTACT1 };
		Cursor c = ourDatabase.query(DATABASE_TABLE1, columns, KEY_ID1 + "="
				+ "'" + num + "'", null, null, null, null);
		List<String> result = new LinkedList<>();

		// int iLocation = c.getColumnIndex(KEY_ID1);
		int iEstablishment = c.getColumnIndex(KEY_NAME1);
		int iContact = c.getColumnIndex(KEY_CONTACT1);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			// result.add(c.getString(iLocation));
			result.add(c.getString(iEstablishment));
			result.add(c.getString(iContact));
		}
		return result;
	}

	public List<String> getAttractions(String num) {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ID2, KEY_NAME2, KEY_DESCRIPTION2, KEY_PICTURE2 };
		Cursor c = ourDatabase.query(DATABASE_TABLE2, columns, KEY_ID2 + "="
				+ "'" + num + "'", null, null, null, null);
		List<String> result = new LinkedList<>();

		// int iLocation = c.getColumnIndex(KEY_ID1);
		int iEstablishment = c.getColumnIndex(KEY_NAME2);
		int iDescription = c.getColumnIndex(KEY_DESCRIPTION2);
		int iPicture = c.getColumnIndex(KEY_PICTURE2);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			// result.add(c.getString(iLocation));
			result.add(c.getString(iEstablishment));
			result.add(c.getString(iDescription));
			result.add(c.getString(iPicture));
		}
		return result;
	}
	
	public void updatePointer(String pointer) {
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_POINTERNAME7, pointer);
		ourDatabase.update(DATABASE_TABLE7, cvUpdate, null, null);
	}

	public String getPointer() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_POINTERID7, KEY_POINTERNAME7 };
		Cursor c = ourDatabase.query(DATABASE_TABLE7, columns, null, null,
				null, null, null);
		String result = "";

		int iName = c.getColumnIndex(KEY_POINTERNAME7);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = c.getString(iName);
		}
		return result;
	}

}
