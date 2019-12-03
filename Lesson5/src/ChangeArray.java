public class ChangeArray
{
    float[] change(float[] arr)
    {
        for(int i = 0; i < Task1.SIZE/2; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        return arr;
    }
}
