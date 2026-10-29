public class canPlaceFlowers {
    public boolean canPlace(int[] flowerbed, int n) {
        int maxPossible = 0, len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            if(flowerbed[i] != 1) {
                boolean left = true, right = true;
                if((i-1) != -1 && flowerbed[i-1] == 1) {
                    left = false;
                }
                if((i+1) != len && flowerbed[i+1] == 1) {
                    right = false;
                }
                if(left && right) {
                    maxPossible++;
                    flowerbed[i] = 1;
                }
            }
        }
        if(n <= maxPossible) {
            return true;
        }
        return false;
    }
}