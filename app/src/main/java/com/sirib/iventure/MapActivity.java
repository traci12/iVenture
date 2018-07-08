package com.sirib.iventure;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MapActivity extends Activity {

	static HashMap<String, Node> index_map = new HashMap<>();
	public static double totalpathcost;
	public static int chooser = 0;

	public static int getCost() {
		return (int) totalpathcost;
	}

	public static List<Node> Graph(String current, String dept) {
		totalpathcost = 0;
		String location = current;
		;
		String destination = dept;
		location.trim();

		// initialize the graph base on the Ilocos Region, Philippines
		Node n1 = new Node("Adams");
		Node n2 = new Node("Pagudpud");
		Node n3 = new Node("Dumalneg");
		Node n4 = new Node("Bangui");
		Node n5 = new Node("Burgos");
		Node n6 = new Node("Pasuquin");
		Node n7 = new Node("Bacarra");
		Node n8 = new Node("Vintar");
		Node n9 = new Node("Laoag City");
		Node n10 = new Node("Piddig");
		Node n11 = new Node("Sarrat");
		Node n12 = new Node("San Nicolas");
		Node n13 = new Node("Paoay");
		Node n14 = new Node("Carasi");
		Node n15 = new Node("Dingras");
		Node n16 = new Node("Marcos");
		Node n17 = new Node("Banna");
		Node n18 = new Node("Batac City");
		Node n19 = new Node("Nueva Era");
		Node n20 = new Node("Pinili");
		Node n21 = new Node("Badoc");
		Node n22 = new Node("Currimao");
		Node n23 = new Node("Solsona");

		// initialize nodes

		index_map.put("Adams", n1);
		index_map.put("Pagudpud", n2);
		index_map.put("Dumalneg", n3);
		index_map.put("Bangui", n4);
		index_map.put("Burgos", n5);
		index_map.put("Pasuquin", n6);
		index_map.put("Bacarra", n7);
		index_map.put("Vintar", n8);
		index_map.put("Laoag City", n9);
		index_map.put("Piddig", n10);
		index_map.put("Sarrat", n11);
		index_map.put("San Nicolas", n12);
		index_map.put("Paoay", n13);
		index_map.put("Carasi", n14);
		index_map.put("Dingras", n15);
		index_map.put("Marcos", n16);
		index_map.put("Banna", n17);
		index_map.put("Batac City", n18);
		index_map.put("Nueva Era", n19);
		index_map.put("Pinili", n20);
		index_map.put("Badoc", n21);
		index_map.put("Currimao", n22);
		index_map.put("Solsona", n23);

		// initialize the edges

		// Adams
		n1.adjacencies = new Edge[] { new Edge(n2, 21) };

		// Pagudpud
		n2.adjacencies = new Edge[] { new Edge(n3, 7), new Edge(n4, 9),
				new Edge(n1, 21) };

		// Dumalneg
		n3.adjacencies = new Edge[] { new Edge(n2, 7) };

		// Bangui
		n4.adjacencies = new Edge[] { new Edge(n2, 9), new Edge(n5, 16) };

		// Burgos
		n5.adjacencies = new Edge[] { new Edge(n4, 16), new Edge(n6, 32) };

		// Pasuquin
		n6.adjacencies = new Edge[] { new Edge(n7, 10), new Edge(n5, 32) };

		// Bacarra
		n7.adjacencies = new Edge[] { new Edge(n8, 8), new Edge(n9, 8),
				new Edge(n6, 10) };

		// Vintar
		n8.adjacencies = new Edge[] { new Edge(n7, 8), new Edge(n9, 8),
				new Edge(n11, 8), new Edge(n10, 10) };

		// Laoag
		n9.adjacencies = new Edge[] { new Edge(n12, 3), new Edge(n7, 8),
				new Edge(n8, 8), new Edge(n11, 8), new Edge(n13, 16) };

		// Piddig
		n10.adjacencies = new Edge[] { new Edge(n15, 2), new Edge(n14, 3),
				new Edge(n8, 10), new Edge(n11, 10), new Edge(n23, 13) };

		// Sarrat
		n11.adjacencies = new Edge[] { new Edge(n12, 5), new Edge(n15, 8),
				new Edge(n8, 8), new Edge(n9, 8), new Edge(n10, 10) };

		// San Nicolas
		n12.adjacencies = new Edge[] { new Edge(n9, 3), new Edge(n11, 5),
				new Edge(n18, 12), new Edge(n13, 13), new Edge(n15, 13) };

		// Paoay
		n13.adjacencies = new Edge[] { new Edge(n18, 1), new Edge(n22, 7),
				new Edge(n12, 13), new Edge(n9, 16) };

		// Carasi
		n14.adjacencies = new Edge[] { new Edge(n10, 3), new Edge(n23, 10) };

		// Dingras
		n15.adjacencies = new Edge[] { new Edge(n10, 2), new Edge(n11, 8),
				new Edge(n16, 10), new Edge(n12, 13), new Edge(n23, 15) };

		// Marcos
		n16.adjacencies = new Edge[] { new Edge(n17, 6), new Edge(n15, 10) };

		// Banna
		n17.adjacencies = new Edge[] { new Edge(n20, 2), new Edge(n16, 6),
				new Edge(n19, 8), new Edge(n18, 17) };

		// Batac
		n18.adjacencies = new Edge[] { new Edge(n13, 1), new Edge(n22, 8),
				new Edge(n12, 12), new Edge(n20, 15), new Edge(n17, 17),
				new Edge(n21, 23) };

		// Nueva Era
		n19.adjacencies = new Edge[] { new Edge(n17, 8), new Edge(n20, 10) };

		// Pinili
		n20.adjacencies = new Edge[] { new Edge(n17, 2), new Edge(n21, 8),
				new Edge(n19, 10), new Edge(n18, 15) };

		// Badoc
		n21.adjacencies = new Edge[] { new Edge(n20, 8), new Edge(n22, 15),
				new Edge(n18, 23) };

		// Curimao
		n22.adjacencies = new Edge[] { new Edge(n13, 7), new Edge(n21, 15),
				new Edge(n18, 18) };

		// Solsona
		n23.adjacencies = new Edge[] { new Edge(n14, 10), new Edge(n10, 13),
				new Edge(n15, 15) };

		Node source = index_map.get(location);
		Node goal = index_map.get(destination);

		UniformCostSearch(source, goal);

		List<Node> path = printPath(goal);

		return path;

	}

	public static void UniformCostSearch(Node source, Node goal) {

		source.pathCost = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20,
				new Comparator<Node>() {

					// override compare method
					public int compare(Node i, Node j) {
						if (i.pathCost > j.pathCost) {
							return 1;
						}

						else if (i.pathCost < j.pathCost) {
							return -1;
						}

						else {
							return 0;
						}
					}
				}

		);

		queue.add(source);
		Set<Node> explored = new HashSet<Node>();
		boolean found = false;

		// while frontier is not empty
		do {

			Node current = queue.poll();
			explored.add(current);
			// System.out.println(current);

			if (current.value.equals(goal.value)) {
				found = true;

			}

			for (Edge e : current.adjacencies) {
				Node child = e.target;
				double cost = e.cost;
				child.pathCost = current.pathCost + cost;

				if (!explored.contains(child) && !queue.contains(child)) {
					if (child.equals(goal))
						totalpathcost = child.pathCost;
					child.parent = current;
					queue.add(child);

				}

				else if ((queue.contains(child))
						&& (child.pathCost > current.pathCost + cost)) {

					child.parent = current;
					child.pathCost = current.pathCost + cost;
					queue.remove(child);
					queue.add(child);

				}

			}

			// System.out.println(queue);

		} while (!queue.isEmpty());

	}

	public static List<Node> printPath(Node target) {
		List<Node> path = new ArrayList<Node>();
		for (Node node = target; node != null; node = node.parent) {
			path.add(node);
		}

		Collections.reverse(path);

		return path;

	}

	Button bContacts, bSpots, bRefresh, b1, b2, b3, b4, b5, b6, b7, b8, b9,
			b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22,
			b23;
	ImageView image, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13,
			i14, i15, i16, i17, i18, i19, i20, i21, i22, i23;
	TextView title, description, location;
	MediaPlayer background, adams, dumalneg, pagudpud, bangui, burgos,
			pasuquin, bacarra, laoag, sannicolas, batac, paoay, currimao,
			badoc, pinili, nuevaera, banna, marcos, dingras, solsona, sarrat,
			piddig, carasi, vintar;
	Button submit1, submit2, submit3, submit4;
	Spinner spinner1, spinner2, spinner3, spinner4;

	int lock = 0;
	String view = "", scores = "Laoag", current, destination, path = "";
	ListView listView;
	String[] values;
	List<String> topic;
	ScrollView tourist;

	final iVentureDatabase info = new iVentureDatabase(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get ListView object from xml

		setContentView(R.layout.activity_map);

		// AddMob Feature ca-app-pub-3940256099942544~3347511713
		MobileAds.initialize(getApplicationContext(), "ca-app-pub-3762334568755246/4653668619");

		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);


		listView = (ListView) findViewById(R.id.list);

		// Assign adapter to ListView

		background = MediaPlayer.create(MapActivity.this, R.raw.bg);
		adams = MediaPlayer.create(MapActivity.this, R.raw.adams);
		dumalneg = MediaPlayer.create(MapActivity.this, R.raw.dumalneg);
		pagudpud = MediaPlayer.create(MapActivity.this, R.raw.pagudpud);
		bangui = MediaPlayer.create(MapActivity.this, R.raw.bangui);
		burgos = MediaPlayer.create(MapActivity.this, R.raw.burgos);
		pasuquin = MediaPlayer.create(MapActivity.this, R.raw.pasuquin);
		bacarra = MediaPlayer.create(MapActivity.this, R.raw.bacarra);
		laoag = MediaPlayer.create(MapActivity.this, R.raw.laoag);
		sannicolas = MediaPlayer.create(MapActivity.this, R.raw.sannicolas);
		batac = MediaPlayer.create(MapActivity.this, R.raw.batac);
		paoay = MediaPlayer.create(MapActivity.this, R.raw.paoay);
		currimao = MediaPlayer.create(MapActivity.this, R.raw.currimao);
		badoc = MediaPlayer.create(MapActivity.this, R.raw.badoc);
		pinili = MediaPlayer.create(MapActivity.this, R.raw.pinili);
		nuevaera = MediaPlayer.create(MapActivity.this, R.raw.nuevaera);
		banna = MediaPlayer.create(MapActivity.this, R.raw.banna);
		marcos = MediaPlayer.create(MapActivity.this, R.raw.marcos);
		dingras = MediaPlayer.create(MapActivity.this, R.raw.dingras);
		solsona = MediaPlayer.create(MapActivity.this, R.raw.solsona);
		sarrat = MediaPlayer.create(MapActivity.this, R.raw.sarrat);
		piddig = MediaPlayer.create(MapActivity.this, R.raw.piddig);
		carasi = MediaPlayer.create(MapActivity.this, R.raw.carasi);
		vintar = MediaPlayer.create(MapActivity.this, R.raw.vintar);

		background.setLooping(true);
		if (!background.isPlaying()) {
			background.start();
		} else {
			background.stop();
		}

		bContacts = (Button) findViewById(R.id.contacts);
		bSpots = (Button) findViewById(R.id.spots);
		bRefresh = (Button) findViewById(R.id.refresh);
		b1 = (Button) findViewById(R.id.adams);
		b2 = (Button) findViewById(R.id.dumalneg);
		b3 = (Button) findViewById(R.id.pagudpud);
		b4 = (Button) findViewById(R.id.bangui);
		b5 = (Button) findViewById(R.id.burgos);
		b6 = (Button) findViewById(R.id.pasuquin);
		b7 = (Button) findViewById(R.id.bacarra);
		b8 = (Button) findViewById(R.id.laoag);
		b9 = (Button) findViewById(R.id.sannicolas);
		b10 = (Button) findViewById(R.id.batac);
		b11 = (Button) findViewById(R.id.paoay);
		b12 = (Button) findViewById(R.id.currimao);
		b13 = (Button) findViewById(R.id.badoc);
		b14 = (Button) findViewById(R.id.pinili);
		b15 = (Button) findViewById(R.id.nuevaera);
		b16 = (Button) findViewById(R.id.banna);
		b17 = (Button) findViewById(R.id.marcos);
		b18 = (Button) findViewById(R.id.dingras);
		b19 = (Button) findViewById(R.id.sarrat);
		b20 = (Button) findViewById(R.id.solsona);
		b21 = (Button) findViewById(R.id.piddig);
		b22 = (Button) findViewById(R.id.carasi);
		b23 = (Button) findViewById(R.id.vintar);
		tourist = (ScrollView) findViewById(R.id.tourist);
		image = (ImageView) findViewById(R.id.image);
		title = (TextView) findViewById(R.id.title);
		description = (TextView) findViewById(R.id.description);

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starte1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.adams);
						background.setBackgroundResource(resID);
						current = "Adams";
						lock = 1;
					} else if (lock == 1) {
						String icon = "deste1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.adams);
						background.setBackgroundResource(resID);
						destination = "Adams";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				adams.start();
			}

		});

		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startc1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.dumalneg);
						background.setBackgroundResource(resID);
						current = "Dumalneg";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destc1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.dumalneg);
						background.setBackgroundResource(resID);
						destination = "Dumalneg";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				dumalneg.start();
			}

		});

		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Pagudpud");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startb1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.pagudpud);
						background.setBackgroundResource(resID);
						current = "Pagudpud";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destb1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.pagudpud);
						background.setBackgroundResource(resID);
						destination = "Pagudpud";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				pagudpud.start();
			}

		});

		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Bangui");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startb2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.bangui);
						background.setBackgroundResource(resID);
						current = "Bangui";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destb2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.bangui);
						background.setBackgroundResource(resID);
						destination = "Bangui";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				bangui.start();
			}

		});

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Burgos");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starta3";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.burgos);
						background.setBackgroundResource(resID);
						current = "Burgos";
						lock = 1;
					} else if (lock == 1) {
						String icon = "desta3";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.burgos);
						background.setBackgroundResource(resID);
						destination = "Burgos";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				burgos.start();
			}

		});

		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startd4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.pasuquin);
						background.setBackgroundResource(resID);
						current = "Pasuquin";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destd4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.pasuquin);
						background.setBackgroundResource(resID);
						destination = "Pasuquin";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				pasuquin.start();
			}

		});

		b7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Bacarra");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starte4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.bacarra);
						background.setBackgroundResource(resID);
						current = "Bacarra";
						lock = 1;
					} else if (lock == 1) {
						String icon = "deste4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.bacarra);
						background.setBackgroundResource(resID);
						destination = "Bacarra";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				bacarra.start();
			}

		});

		b8.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Laoag");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 2) {
					info.open();
					info.updatePointer("Laoag");
					scores = info.getPointer();
					topic = info.getContact(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startf4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.laoag);
						background.setBackgroundResource(resID);
						current = "Laoag City";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destf4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.laoag);
						background.setBackgroundResource(resID);
						destination = "Laoag City";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				laoag.start();
			}

		});

		b9.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 2) {
					info.open();
					info.updatePointer("San Nicolas");
					scores = info.getPointer();
					topic = info.getContact(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startg4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.sannicolas);
						background.setBackgroundResource(resID);
						current = "San Nicolas";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destg4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.sannicolas);
						background.setBackgroundResource(resID);
						destination = "San Nicolas";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				sannicolas.start();
			}

		});

		b10.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Batac");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 2) {
					info.open();
					info.updatePointer("Batac");
					scores = info.getPointer();
					topic = info.getContact(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starth4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.batac);
						background.setBackgroundResource(resID);
						current = "Batac City";
						lock = 1;
					} else if (lock == 1) {
						String icon = "desth4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.batac);
						background.setBackgroundResource(resID);
						destination = "Batac City";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				batac.start();
			}

		});

		b11.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Paoay");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starth5";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.paoay);
						background.setBackgroundResource(resID);
						current = "Paoay";
						lock = 1;
					} else if (lock == 1) {
						String icon = "desth5";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.paoay);
						background.setBackgroundResource(resID);
						destination = "Paoay";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				paoay.start();
			}

		});

		b12.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Currimao");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 2) {
					info.open();
					info.updatePointer("Currimao");
					scores = info.getPointer();
					topic = info.getContact(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starti5";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.currimao);
						background.setBackgroundResource(resID);
						current = "Currimao";
						lock = 1;
					} else if (lock == 1) {
						String icon = "desti5";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.currimao);
						background.setBackgroundResource(resID);
						destination = "Currimao";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				currimao.start();
			}

		});

		b13.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 1) {
					info.open();
					info.updatePointer("Badoc");
					scores = info.getPointer();
					topic = info.getAttractions(scores); // get Contact
					info.close();
					view = topic.get(0);
					listView.setVisibility(View.VISIBLE);
					onResume();
				}
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startk5";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.badoc);
						background.setBackgroundResource(resID);
						current = "Badoc";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destk5";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.badoc);
						background.setBackgroundResource(resID);
						destination = "Badoc";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				badoc.start();
			}

		});

		b14.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startj4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.pinili);
						background.setBackgroundResource(resID);
						current = "Pinili";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destj4";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.pinili);
						background.setBackgroundResource(resID);
						destination = "Pinili";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				pinili.start();
			}

		});

		b15.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startk2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.nuevaera);
						background.setBackgroundResource(resID);
						current = "Nueva Era";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destk2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.nuevaera);
						background.setBackgroundResource(resID);
						destination = "Nueva Era";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				nuevaera.start();
			}

		});

		b16.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startj2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.banna);
						background.setBackgroundResource(resID);
						current = "Banna";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destj2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.banna);
						background.setBackgroundResource(resID);
						destination = "Banna";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				banna.start();
			}

		});

		b17.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starti2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.marcos);
						background.setBackgroundResource(resID);
						current = "Marcos";
						lock = 1;
					} else if (lock == 1) {
						String icon = "desti2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.marcos);
						background.setBackgroundResource(resID);
						destination = "Marcos";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				marcos.start();
			}

		});

		b18.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starth2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.dingras);
						background.setBackgroundResource(resID);
						current = "Dingras";
						lock = 1;
					} else if (lock == 1) {
						String icon = "desth2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.dingras);
						background.setBackgroundResource(resID);
						destination = "Dingras";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				dingras.start();
			}

		});

		b19.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startg3";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.sarrat);
						background.setBackgroundResource(resID);
						current = "Sarrat";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destg3";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.sarrat);
						background.setBackgroundResource(resID);
						destination = "Sarrat";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				sarrat.start();
			}

		});

		b20.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "starth1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.solsona);
						background.setBackgroundResource(resID);
						current = "Solsona";
						lock = 1;
					} else if (lock == 1) {
						String icon = "desth1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.solsona);
						background.setBackgroundResource(resID);
						destination = "Solsona";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				solsona.start();
			}

		});

		b21.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startg2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.piddig);
						background.setBackgroundResource(resID);
						current = "Piddig";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destg2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.piddig);
						background.setBackgroundResource(resID);
						destination = "Piddig";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				piddig.start();
			}

		});

		b22.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startg1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.carasi);
						background.setBackgroundResource(resID);
						current = "Carasi";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destg1";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.carasi);
						background.setBackgroundResource(resID);
						destination = "Carasi";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				carasi.start();
			}

		});

		b23.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (chooser == 0) {
					if (lock == 0) {
						String icon1 = "e1";
						int resID1 = getResources().getIdentifier(icon1,
								"drawable", getPackageName());
						View background1 = findViewById(R.id.adams);
						background1.setBackgroundResource(resID1);
						String icon2 = "c1";
						int resID2 = getResources().getIdentifier(icon2,
								"drawable", getPackageName());
						View background2 = findViewById(R.id.dumalneg);
						background2.setBackgroundResource(resID2);
						String icon3 = "b1";
						int resID3 = getResources().getIdentifier(icon3,
								"drawable", getPackageName());
						View background3 = findViewById(R.id.pagudpud);
						background3.setBackgroundResource(resID3);
						String icon4 = "b2";
						int resID4 = getResources().getIdentifier(icon4,
								"drawable", getPackageName());
						View background4 = findViewById(R.id.bangui);
						background4.setBackgroundResource(resID4);
						String icon5 = "a3";
						int resID5 = getResources().getIdentifier(icon5,
								"drawable", getPackageName());
						View background5 = findViewById(R.id.burgos);
						background5.setBackgroundResource(resID5);
						String icon6 = "d4";
						int resID6 = getResources().getIdentifier(icon6,
								"drawable", getPackageName());
						View background6 = findViewById(R.id.pasuquin);
						background6.setBackgroundResource(resID6);
						String icon7 = "e4";
						int resID7 = getResources().getIdentifier(icon7,
								"drawable", getPackageName());
						View background7 = findViewById(R.id.bacarra);
						background7.setBackgroundResource(resID7);
						String icon8 = "fs4";
						int resID8 = getResources().getIdentifier(icon8,
								"drawable", getPackageName());
						View background8 = findViewById(R.id.laoag);
						background8.setBackgroundResource(resID8);
						String icon9 = "gs4";
						int resID9 = getResources().getIdentifier(icon9,
								"drawable", getPackageName());
						View background9 = findViewById(R.id.sannicolas);
						background9.setBackgroundResource(resID9);
						String icon10 = "h4";
						int resID10 = getResources().getIdentifier(icon10,
								"drawable", getPackageName());
						View background10 = findViewById(R.id.batac);
						background10.setBackgroundResource(resID10);
						String icon11 = "h5";
						int resID11 = getResources().getIdentifier(icon11,
								"drawable", getPackageName());
						View background11 = findViewById(R.id.paoay);
						background11.setBackgroundResource(resID11);
						String icon12 = "i5";
						int resID12 = getResources().getIdentifier(icon12,
								"drawable", getPackageName());
						View background12 = findViewById(R.id.currimao);
						background12.setBackgroundResource(resID12);
						String icon13 = "k5";
						int resID13 = getResources().getIdentifier(icon13,
								"drawable", getPackageName());
						View background13 = findViewById(R.id.badoc);
						background13.setBackgroundResource(resID13);
						String icon14 = "j4";
						int resID14 = getResources().getIdentifier(icon14,
								"drawable", getPackageName());
						View background14 = findViewById(R.id.pinili);
						background14.setBackgroundResource(resID14);
						String icon15 = "k2";
						int resID15 = getResources().getIdentifier(icon15,
								"drawable", getPackageName());
						View background15 = findViewById(R.id.nuevaera);
						background15.setBackgroundResource(resID15);
						String icon16 = "j2";
						int resID16 = getResources().getIdentifier(icon16,
								"drawable", getPackageName());
						View background16 = findViewById(R.id.banna);
						background16.setBackgroundResource(resID16);
						String icon17 = "i2";
						int resID17 = getResources().getIdentifier(icon17,
								"drawable", getPackageName());
						View background17 = findViewById(R.id.marcos);
						background17.setBackgroundResource(resID17);
						String icon18 = "h2";
						int resID18 = getResources().getIdentifier(icon18,
								"drawable", getPackageName());
						View background18 = findViewById(R.id.dingras);
						background18.setBackgroundResource(resID18);
						String icon19 = "g3";
						int resID19 = getResources().getIdentifier(icon19,
								"drawable", getPackageName());
						View background19 = findViewById(R.id.sarrat);
						background19.setBackgroundResource(resID19);
						String icon20 = "h1";
						int resID20 = getResources().getIdentifier(icon20,
								"drawable", getPackageName());
						View background20 = findViewById(R.id.solsona);
						background20.setBackgroundResource(resID20);
						String icon21 = "g2";
						int resID21 = getResources().getIdentifier(icon21,
								"drawable", getPackageName());
						View background21 = findViewById(R.id.piddig);
						background21.setBackgroundResource(resID21);
						String icon22 = "g1";
						int resID22 = getResources().getIdentifier(icon22,
								"drawable", getPackageName());
						View background22 = findViewById(R.id.carasi);
						background22.setBackgroundResource(resID22);
						String icon23 = "f2";
						int resID23 = getResources().getIdentifier(icon23,
								"drawable", getPackageName());
						View background23 = findViewById(R.id.vintar);
						background23.setBackgroundResource(resID23);

						String icon = "startf2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.vintar);
						background.setBackgroundResource(resID);
						current = "Vintar";
						lock = 1;
					} else if (lock == 1) {
						String icon = "destf2";
						int resID = getResources().getIdentifier(icon,
								"drawable", getPackageName());
						View background = findViewById(R.id.vintar);
						background.setBackgroundResource(resID);
						destination = "Vintar";
						List<Node> graph = Graph(current, destination);
						int size = graph.size();
						path = "" + graph.get(0);
						for (int x = 1; x < size; x++) {
							path = path + " -> " + graph.get(x);
						}
						AlertDialog.Builder ad = new AlertDialog.Builder(
								MapActivity.this);
						ad.setCancelable(false);
						ad.setTitle("Distance");
						ad.setMessage("The path is from " + path.toUpperCase()
								+ " with an estimated distance of " + getCost()
								+ "km.");
						ad.setNegativeButton("Ok",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						ad.show();
						lock = 0;
						path = "";
						graph.clear();
					}
				}
				vintar.start();
			}

		});

		bRefresh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				lock = 0;
				tourist.setVisibility(View.GONE);
				listView.setVisibility(View.GONE);
				chooser = 0;
				String icon1 = "e1";
				int resID1 = getResources().getIdentifier(icon1, "drawable",
						getPackageName());
				View background1 = findViewById(R.id.adams);
				background1.setBackgroundResource(resID1);
				String icon2 = "c1";
				int resID2 = getResources().getIdentifier(icon2, "drawable",
						getPackageName());
				View background2 = findViewById(R.id.dumalneg);
				background2.setBackgroundResource(resID2);
				String icon3 = "b1";
				int resID3 = getResources().getIdentifier(icon3, "drawable",
						getPackageName());
				View background3 = findViewById(R.id.pagudpud);
				background3.setBackgroundResource(resID3);
				String icon4 = "b2";
				int resID4 = getResources().getIdentifier(icon4, "drawable",
						getPackageName());
				View background4 = findViewById(R.id.bangui);
				background4.setBackgroundResource(resID4);
				String icon5 = "a3";
				int resID5 = getResources().getIdentifier(icon5, "drawable",
						getPackageName());
				View background5 = findViewById(R.id.burgos);
				background5.setBackgroundResource(resID5);
				String icon6 = "d4";
				int resID6 = getResources().getIdentifier(icon6, "drawable",
						getPackageName());
				View background6 = findViewById(R.id.pasuquin);
				background6.setBackgroundResource(resID6);
				String icon7 = "e4";
				int resID7 = getResources().getIdentifier(icon7, "drawable",
						getPackageName());
				View background7 = findViewById(R.id.bacarra);
				background7.setBackgroundResource(resID7);
				String icon8 = "fs4";
				int resID8 = getResources().getIdentifier(icon8, "drawable",
						getPackageName());
				View background8 = findViewById(R.id.laoag);
				background8.setBackgroundResource(resID8);
				String icon9 = "gs4";
				int resID9 = getResources().getIdentifier(icon9, "drawable",
						getPackageName());
				View background9 = findViewById(R.id.sannicolas);
				background9.setBackgroundResource(resID9);
				String icon10 = "h4";
				int resID10 = getResources().getIdentifier(icon10, "drawable",
						getPackageName());
				View background10 = findViewById(R.id.batac);
				background10.setBackgroundResource(resID10);
				String icon11 = "h5";
				int resID11 = getResources().getIdentifier(icon11, "drawable",
						getPackageName());
				View background11 = findViewById(R.id.paoay);
				background11.setBackgroundResource(resID11);
				String icon12 = "i5";
				int resID12 = getResources().getIdentifier(icon12, "drawable",
						getPackageName());
				View background12 = findViewById(R.id.currimao);
				background12.setBackgroundResource(resID12);
				String icon13 = "k5";
				int resID13 = getResources().getIdentifier(icon13, "drawable",
						getPackageName());
				View background13 = findViewById(R.id.badoc);
				background13.setBackgroundResource(resID13);
				String icon14 = "j4";
				int resID14 = getResources().getIdentifier(icon14, "drawable",
						getPackageName());
				View background14 = findViewById(R.id.pinili);
				background14.setBackgroundResource(resID14);
				String icon15 = "k2";
				int resID15 = getResources().getIdentifier(icon15, "drawable",
						getPackageName());
				View background15 = findViewById(R.id.nuevaera);
				background15.setBackgroundResource(resID15);
				String icon16 = "j2";
				int resID16 = getResources().getIdentifier(icon16, "drawable",
						getPackageName());
				View background16 = findViewById(R.id.banna);
				background16.setBackgroundResource(resID16);
				String icon17 = "i2";
				int resID17 = getResources().getIdentifier(icon17, "drawable",
						getPackageName());
				View background17 = findViewById(R.id.marcos);
				background17.setBackgroundResource(resID17);
				String icon18 = "h2";
				int resID18 = getResources().getIdentifier(icon18, "drawable",
						getPackageName());
				View background18 = findViewById(R.id.dingras);
				background18.setBackgroundResource(resID18);
				String icon19 = "g3";
				int resID19 = getResources().getIdentifier(icon19, "drawable",
						getPackageName());
				View background19 = findViewById(R.id.sarrat);
				background19.setBackgroundResource(resID19);
				String icon20 = "h1";
				int resID20 = getResources().getIdentifier(icon20, "drawable",
						getPackageName());
				View background20 = findViewById(R.id.solsona);
				background20.setBackgroundResource(resID20);
				String icon21 = "g2";
				int resID21 = getResources().getIdentifier(icon21, "drawable",
						getPackageName());
				View background21 = findViewById(R.id.piddig);
				background21.setBackgroundResource(resID21);
				String icon22 = "g1";
				int resID22 = getResources().getIdentifier(icon22, "drawable",
						getPackageName());
				View background22 = findViewById(R.id.carasi);
				background22.setBackgroundResource(resID22);
				String icon23 = "f2";
				int resID23 = getResources().getIdentifier(icon23, "drawable",
						getPackageName());
				View background23 = findViewById(R.id.vintar);
				background23.setBackgroundResource(resID23);
			}

		});

		bContacts.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				tourist.setVisibility(View.GONE);
				listView.setVisibility(View.GONE);
				chooser = 2;
				String icon3 = "b1";
				int resID3 = getResources().getIdentifier(icon3, "drawable",
						getPackageName());
				View background3 = findViewById(R.id.pagudpud);
				background3.setBackgroundResource(resID3);
				String icon4 = "b2";
				int resID4 = getResources().getIdentifier(icon4, "drawable",
						getPackageName());
				View background4 = findViewById(R.id.bangui);
				background4.setBackgroundResource(resID4);
				String icon5 = "a3";
				int resID5 = getResources().getIdentifier(icon5, "drawable",
						getPackageName());
				View background5 = findViewById(R.id.burgos);
				background5.setBackgroundResource(resID5);
				String icon7 = "e4";
				int resID7 = getResources().getIdentifier(icon7, "drawable",
						getPackageName());
				View background7 = findViewById(R.id.bacarra);
				background7.setBackgroundResource(resID7);
				String icon8 = "laoag";
				int resID8 = getResources().getIdentifier(icon8, "drawable",
						getPackageName());
				View background8 = findViewById(R.id.laoag);
				background8.setBackgroundResource(resID8);
				String icon9 = "sannicolas";
				int resID9 = getResources().getIdentifier(icon9, "drawable",
						getPackageName());
				View background9 = findViewById(R.id.sannicolas);
				background9.setBackgroundResource(resID9);
				String icon10 = "batac";
				int resID10 = getResources().getIdentifier(icon10, "drawable",
						getPackageName());
				View background10 = findViewById(R.id.batac);
				background10.setBackgroundResource(resID10);
				String icon11 = "h5";
				int resID11 = getResources().getIdentifier(icon11, "drawable",
						getPackageName());
				View background11 = findViewById(R.id.paoay);
				background11.setBackgroundResource(resID11);
				String icon13 = "k5";
				int resID13 = getResources().getIdentifier(icon13, "drawable",
						getPackageName());
				View background13 = findViewById(R.id.badoc);
				background13.setBackgroundResource(resID13);
				String icon12 = "currimao";
				int resID12 = getResources().getIdentifier(icon12, "drawable",
						getPackageName());
				View background12 = findViewById(R.id.currimao);
				background12.setBackgroundResource(resID12);
				String icon1 = "e1";
				int resID1 = getResources().getIdentifier(icon1, "drawable",
						getPackageName());
				View background1 = findViewById(R.id.adams);
				background1.setBackgroundResource(resID1);
				String icon2 = "c1";
				int resID2 = getResources().getIdentifier(icon2, "drawable",
						getPackageName());
				View background2 = findViewById(R.id.dumalneg);
				background2.setBackgroundResource(resID2);
				String icon6 = "d4";
				int resID6 = getResources().getIdentifier(icon6, "drawable",
						getPackageName());
				View background6 = findViewById(R.id.pasuquin);
				background6.setBackgroundResource(resID6);
				String icon14 = "j4";
				int resID14 = getResources().getIdentifier(icon14, "drawable",
						getPackageName());
				View background14 = findViewById(R.id.pinili);
				background14.setBackgroundResource(resID14);
				String icon15 = "k2";
				int resID15 = getResources().getIdentifier(icon15, "drawable",
						getPackageName());
				View background15 = findViewById(R.id.nuevaera);
				background15.setBackgroundResource(resID15);
				String icon16 = "j2";
				int resID16 = getResources().getIdentifier(icon16, "drawable",
						getPackageName());
				View background16 = findViewById(R.id.banna);
				background16.setBackgroundResource(resID16);
				String icon17 = "i2";
				int resID17 = getResources().getIdentifier(icon17, "drawable",
						getPackageName());
				View background17 = findViewById(R.id.marcos);
				background17.setBackgroundResource(resID17);
				String icon18 = "h2";
				int resID18 = getResources().getIdentifier(icon18, "drawable",
						getPackageName());
				View background18 = findViewById(R.id.dingras);
				background18.setBackgroundResource(resID18);
				String icon19 = "g3";
				int resID19 = getResources().getIdentifier(icon19, "drawable",
						getPackageName());
				View background19 = findViewById(R.id.sarrat);
				background19.setBackgroundResource(resID19);
				String icon20 = "h1";
				int resID20 = getResources().getIdentifier(icon20, "drawable",
						getPackageName());
				View background20 = findViewById(R.id.solsona);
				background20.setBackgroundResource(resID20);
				String icon21 = "g2";
				int resID21 = getResources().getIdentifier(icon21, "drawable",
						getPackageName());
				View background21 = findViewById(R.id.piddig);
				background21.setBackgroundResource(resID21);
				String icon22 = "g1";
				int resID22 = getResources().getIdentifier(icon22, "drawable",
						getPackageName());
				View background22 = findViewById(R.id.carasi);
				background22.setBackgroundResource(resID22);
				String icon23 = "f2";
				int resID23 = getResources().getIdentifier(icon23, "drawable",
						getPackageName());
				View background23 = findViewById(R.id.vintar);
				background23.setBackgroundResource(resID23);
			}

		});

		bSpots.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				tourist.setVisibility(View.GONE);
				listView.setVisibility(View.GONE);
				chooser = 1;
				String icon3 = "pagudpudlocation";
				int resID3 = getResources().getIdentifier(icon3, "drawable",
						getPackageName());
				View background3 = findViewById(R.id.pagudpud);
				background3.setBackgroundResource(resID3);
				String icon4 = "banguilocation";
				int resID4 = getResources().getIdentifier(icon4, "drawable",
						getPackageName());
				View background4 = findViewById(R.id.bangui);
				background4.setBackgroundResource(resID4);
				String icon5 = "burgoslocation";
				int resID5 = getResources().getIdentifier(icon5, "drawable",
						getPackageName());
				View background5 = findViewById(R.id.burgos);
				background5.setBackgroundResource(resID5);
				String icon7 = "bacarralocation";
				int resID7 = getResources().getIdentifier(icon7, "drawable",
						getPackageName());
				View background7 = findViewById(R.id.bacarra);
				background7.setBackgroundResource(resID7);
				String icon8 = "laoaglocation";
				int resID8 = getResources().getIdentifier(icon8, "drawable",
						getPackageName());
				View background8 = findViewById(R.id.laoag);
				background8.setBackgroundResource(resID8);
				String icon9 = "gs4";
				int resID9 = getResources().getIdentifier(icon9, "drawable",
						getPackageName());
				View background9 = findViewById(R.id.sannicolas);
				background9.setBackgroundResource(resID9);
				String icon10 = "bataclocation";
				int resID10 = getResources().getIdentifier(icon10, "drawable",
						getPackageName());
				View background10 = findViewById(R.id.batac);
				background10.setBackgroundResource(resID10);
				String icon11 = "paoaylocation";
				int resID11 = getResources().getIdentifier(icon11, "drawable",
						getPackageName());
				View background11 = findViewById(R.id.paoay);
				background11.setBackgroundResource(resID11);
				String icon12 = "currimaolocation";
				int resID12 = getResources().getIdentifier(icon12, "drawable",
						getPackageName());
				View background12 = findViewById(R.id.currimao);
				background12.setBackgroundResource(resID12);
				String icon13 = "badoclocation";
				int resID13 = getResources().getIdentifier(icon13, "drawable",
						getPackageName());
				View background13 = findViewById(R.id.badoc);
				background13.setBackgroundResource(resID13);
				String icon1 = "e1";
				int resID1 = getResources().getIdentifier(icon1, "drawable",
						getPackageName());
				View background1 = findViewById(R.id.adams);
				background1.setBackgroundResource(resID1);
				String icon2 = "c1";
				int resID2 = getResources().getIdentifier(icon2, "drawable",
						getPackageName());
				View background2 = findViewById(R.id.dumalneg);
				background2.setBackgroundResource(resID2);
				String icon6 = "d4";
				int resID6 = getResources().getIdentifier(icon6, "drawable",
						getPackageName());
				View background6 = findViewById(R.id.pasuquin);
				background6.setBackgroundResource(resID6);
				String icon14 = "j4";
				int resID14 = getResources().getIdentifier(icon14, "drawable",
						getPackageName());
				View background14 = findViewById(R.id.pinili);
				background14.setBackgroundResource(resID14);
				String icon15 = "k2";
				int resID15 = getResources().getIdentifier(icon15, "drawable",
						getPackageName());
				View background15 = findViewById(R.id.nuevaera);
				background15.setBackgroundResource(resID15);
				String icon16 = "j2";
				int resID16 = getResources().getIdentifier(icon16, "drawable",
						getPackageName());
				View background16 = findViewById(R.id.banna);
				background16.setBackgroundResource(resID16);
				String icon17 = "i2";
				int resID17 = getResources().getIdentifier(icon17, "drawable",
						getPackageName());
				View background17 = findViewById(R.id.marcos);
				background17.setBackgroundResource(resID17);
				String icon18 = "h2";
				int resID18 = getResources().getIdentifier(icon18, "drawable",
						getPackageName());
				View background18 = findViewById(R.id.dingras);
				background18.setBackgroundResource(resID18);
				String icon19 = "g3";
				int resID19 = getResources().getIdentifier(icon19, "drawable",
						getPackageName());
				View background19 = findViewById(R.id.sarrat);
				background19.setBackgroundResource(resID19);
				String icon20 = "h1";
				int resID20 = getResources().getIdentifier(icon20, "drawable",
						getPackageName());
				View background20 = findViewById(R.id.solsona);
				background20.setBackgroundResource(resID20);
				String icon21 = "g2";
				int resID21 = getResources().getIdentifier(icon21, "drawable",
						getPackageName());
				View background21 = findViewById(R.id.piddig);
				background21.setBackgroundResource(resID21);
				String icon22 = "g1";
				int resID22 = getResources().getIdentifier(icon22, "drawable",
						getPackageName());
				View background22 = findViewById(R.id.carasi);
				background22.setBackgroundResource(resID22);
				String icon23 = "f2";
				int resID23 = getResources().getIdentifier(icon23, "drawable",
						getPackageName());
				View background23 = findViewById(R.id.vintar);
				background23.setBackgroundResource(resID23);
			}

		});

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView arg0, View v, int position,
					long id) {
				
				if (chooser == 1) {
					tourist.setVisibility(View.VISIBLE);
					String num = topic.get(1);
					String[] desc = num.split(",");
					String num2 = topic.get(2);
					String[] pic = num2.split(",");
					
	                String  itemValue    = (String) listView.getItemAtPosition(position);
	                title.setText(itemValue);
					description.setText(desc[position]);
					String icon23 = pic[position];
					int resID23 = getResources().getIdentifier(icon23, "drawable",
							getPackageName());
					View background23 = findViewById(R.id.image);
					background23.setBackgroundResource(resID23);
				}
				if (chooser == 2) {
					String num = topic.get(1);
					String[] contact = num.split(",");

					AlertDialog.Builder adb = new AlertDialog.Builder(
							MapActivity.this);
					adb.setTitle("Contact Number");
					adb.setMessage(contact[position]);
					adb.setNegativeButton("Ok",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									dialog.cancel();
								}
							});
					adb.show();
				}
				
			}
		});

	}

	public void onResume() {
		super.onResume();
		if(!background.isPlaying()) {
			background.start();
		}
		// Defined Array values to show in ListView
		values = view.split(",");

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		listView.setAdapter(adapter);

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if(background.isPlaying()) {
			background.pause();	
		}
	}

}

class Node {
	public final String value;
	public double pathCost;
	public Edge[] adjacencies;
	public Node parent;

	public Node(String val) {

		value = val;

	}

	public String toString() {
		return value;
	}
}

class Edge {
	public final double cost;
	public final Node target;

	public Edge(Node targetNode, double costVal) {
		cost = costVal;
		target = targetNode;

	}
}
