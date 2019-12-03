package br.unicamp.cotuca.pathbetweencities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import br.unicamp.cotuca.pathbetweencities.cidade.Cidade;

public class CidadeView extends LinearLayout {

    Cidade[] cidades;
    boolean ePonto, eDijkstra;
    int[] verticesDijkstra;

    public int[] getVerticesDijkstra() {
        return verticesDijkstra;
    }

    public void setVerticesDijkstra(int[] verticesDijkstra) {
        this.verticesDijkstra = verticesDijkstra;
    }

    public boolean iseDijkstra() {
        return eDijkstra;
    }

    public void seteDijkstra(boolean eDijkstra) {
        this.eDijkstra = eDijkstra;
    }

    public boolean isePonto() {
        return ePonto;
    }

    public void setePonto(boolean ePonto) {
        this.ePonto = ePonto;
    }

    public Cidade[] getCidades() {
        return cidades;
    }

    public void setCidades(Cidade[] cidades) {
        this.cidades = cidades;
    }


    public CidadeView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public CidadeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public CidadeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
    }

    public CidadeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(ePonto){
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);
            for(Cidade c : getCidades())
                canvas.drawCircle(c.getCoordenadaX()*717, c.getCoordenadaY()*578, 5, paint);
        }else if(!ePonto && !eDijkstra){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(6f);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            for(int i = 0; i < cidades.length; i++){
                canvas.drawLine(cidades[i].getCoordenadaX()*717, cidades[i].getCoordenadaY()*578,
                cidades[i+1].getCoordenadaX()*717, cidades[i+1].getCoordenadaY()*578, paint);
                i++;
            }
        }
        if(eDijkstra){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(6f);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            int[] cidadesIndices = this.getVerticesDijkstra();
            int c1 = 0, c2 = 0;
            while(c1 < cidadesIndices.length && c2 < cidadesIndices.length){
                c2++;
                if(c2 < cidadesIndices.length)
                    canvas.drawLine(cidades[cidadesIndices[c1]].getCoordenadaX()*717, cidades[cidadesIndices[c1]].getCoordenadaY()*578,
                        cidades[cidadesIndices[c2]].getCoordenadaX()*717, cidades[cidadesIndices[c2]].getCoordenadaY()*578, paint);
                c1 = c2;
            }
        }
    }
}
