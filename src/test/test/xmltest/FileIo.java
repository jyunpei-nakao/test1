package test.test.xmltest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class FileIo extends Activity {
	
	

	// セーブファイル名
	private static final String FILE_NAME = "savedate";
	// 初期記録：タイム
	private static final String INI_TIME = "60.0";
	// 初期記録：スコア
	private static final String INI_SCORE = "000";
	// ゲームモード：タイムアタック
	private static final String TIME = "time";
	// ゲームモード：スコアアタック
	private static final String SCORE = "score";
	// エラー
	private static final String ERR ="err";

	/**
	 * セーブデータファイル作成
	 */
	public boolean createSaveFile() {
		SharedPreferences pri = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
		Editor e = pri.edit();
		e.putString(TIME, INI_TIME);
		e.putString(SCORE, INI_SCORE);
		return e.commit();
	}

	/**
	 * ベストタイム取得処理
	 *
	 * @return ベストタイム
	 *
	 * 取得エラーの場合初期値を返却
	 */
	public String getBestTime() {
		String time =getBestDate(TIME);
		if(ERR.equals(time)){
			time = INI_TIME;
		}
		return time;
	}

	/**
	 * ベストスコア取得処理
	 *
	 * @return ベストスコア
	 *
	 * 取得エラーの場合初期値を返却
	 */
	public String getBestScore() {
		String score = getBestDate(SCORE);
		if(ERR.equals(score)){
			score = INI_SCORE;
		}
		return score;
	}

	/**
	 * ファイル取得処理
	 *
	 * @param key ゲームモード
	 * @return ベスト記録
	 */
	protected String getBestDate(String key) {
		SharedPreferences pri = getSharedPreferences(FILE_NAME, MODE_PRIVATE);

		return pri.getString(key, ERR);
	}

	/**
	 * ベストタイム更新処理
	 *
	 * @param bestTime ベストタイム
	 */
	public void updateBestTime(String bestTime) {
		updeteBestDate(TIME, bestTime);
	}

	/**
	 * ベストスコア更新処理
	 *
	 * @param bestScore ベストスコア
	 */
	public void updateBestScore(String bestScore) {
		updeteBestDate(SCORE, bestScore);
	}

	/**
	 * ファイル更新処理
	 *
	 * @param key ゲームモード
	 * @param deta 更新記録
	 * @return true：更新成功 false：更新失敗
	 */
	protected boolean updeteBestDate(String key, String date) {
		SharedPreferences pri = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
		Editor e = pri.edit();
		e.remove(key);
		e.putString(key, date);

		return e.commit();
	}


}
