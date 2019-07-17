package math;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matrix4f {

    private static final int SIZE = 2*3;
    private float[] elements = new float[ SIZE ];
    
    public static Matrix4f identity(){
        Matrix4f matrix4f = new Matrix4f();

        return matrix4f;
    }

    public static Matrix4f orthographic(float topLeft, float bottomLeft, float topRight, float bottomRight){
        Matrix4f result = identity();
//        result.elements[ ]
        return result;
    }
}
