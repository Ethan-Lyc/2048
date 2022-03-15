package game.resource;
import java.awt.Graphics;
/**
 * Data类用于储存游戏中的分数信息?
 * 定义了绘制得分板以及最高分计分板、分数数字的显示分数的功能
 *
 */
public class Data {
	public static final int SCORE_X = 80; // 得分计分板图片的原点x坐标
	public static final int SCORE_Y = 20; // 得分计分板图片的原点y坐标
	public static final int HIGHTSCORE_X = 280; // 最高分数计分板的原点x坐标
	public static final int HIGHTSCORE_Y = 20;  // 最高分数计分板的原点y坐标
	public static final int SIZE_NUM = 21;// 数字图片中一个数字占的像素大小是21(宽高都是)
	public static final int SIZE_SCORE = 140;// 分数与最高分图片宽度 都是140像素
	
	private int score;//当前得分
	private int hightScore;//最高得分
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getHightScore() {
		return hightScore;
	}
	public void setHightScore(int hightScore) {
		this.hightScore = hightScore;
	}
	//实现计分板功能，包括绘制计分板背景图和得分最高分数据显示功能  
	public void drawData(Graphics g){
		g.drawImage(Resource.img_score, SCORE_X,SCORE_Y, null);
		g.drawImage(Resource.img_highScore,HIGHTSCORE_X,HIGHTSCORE_Y,null);
		drawScore(g);
		drawHightScore(g);
	}
	//显示得分数据
	public void drawScore(Graphics g){
		String score_str = score+"";
		for(int i=0;i<score_str.length();i++){
			int scoreBit = score_str.charAt(i)-'0'; 
			int numPos = scoreBit*SIZE_NUM; 
			int mid = SCORE_X+SIZE_SCORE/2; 
			
			g.drawImage(
					Resource.img_num, 
				    
					mid-score_str.length()*SIZE_NUM/2+i*SIZE_NUM, 
					SCORE_Y+50, 
					mid-score_str.length()*SIZE_NUM/2+i*SIZE_NUM+SIZE_NUM, 
					SCORE_Y+50+SIZE_NUM, 
					numPos, 
					0, 
					numPos+SIZE_NUM, 
					SIZE_NUM, 
					null);
		}
	}

	public void drawHightScore(Graphics g){
		String hightScore_str = hightScore+"";
		for(int i=0;i<hightScore_str.length();i++){
			int bit = hightScore_str.charAt(i)-'0';
			int numPos = bit*SIZE_NUM;
			int mid = HIGHTSCORE_X+SIZE_SCORE/2;
			g.drawImage(
					Resource.img_num,
					mid-hightScore_str.length()*SIZE_NUM/2+i*SIZE_NUM,
					HIGHTSCORE_Y + 50,
					mid-hightScore_str.length()*SIZE_NUM/2+i*SIZE_NUM+SIZE_NUM,
					HIGHTSCORE_Y + 50 + SIZE_NUM,
					numPos,
					0,
					numPos+SIZE_NUM,
					SIZE_NUM,
					null);
		}
	}
}
