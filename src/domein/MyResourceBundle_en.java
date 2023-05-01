package domein;

import java.util.ListResourceBundle;

public class MyResourceBundle_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return new Object[][] {
			{"btnSpelerAanmelden","Register player"},
			{"btnAppStoppen","Exit"},
			{"btnOverzichtSpelers","Overview players"},
			{"btnLogIn","Log in"},
			{"btnStartSpel","Start game"},
			{"btnTerug","Back"},
			{"lblGeboortejaar","Birth year"},
			{"lblGebruikersnaam","Username"},
			{"btnFicheKiezen","Choose gem"},
			{"btnKaartKopen","Buy development card"},
			{"btnStartRonde","Start round"},
			{"btnVolgende","Next"},
			{"lblPrestigepunten","Prestige points:"},
			{"lblSpeler","Player:"},
			{"lblWinnaar","Winner"},
			{"lblOverzicht","Overview"},
		};
	}

}
