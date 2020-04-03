package com.ipaynow.bcfinance.sort;


/**
 * @author Wu
 * @date 2020-03-25 10:26
 */
public class Sort {


    public static void main(String[] args) {
        int[] array = {10, 7, 13, 8, 4, 6};
//        int[] array = {1, 2, 3, 4, 5, 6};
        // insertionSort(array);
        //bubbleSort(array);
        selectSort(array);
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    /**
     * 插入排序
     * 从数组的第二个元素开始，根据之前已经排序好的数据确定要插入
     * 的位置，通过右移或者左移的方式将目标位置空出，进行插入
     *
     * O(n^2) 稳定排序
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        int tmp;
        for (int i = 1; i < array.length; i++) {
            //i 为数组中待插入的元素
            tmp = array[i];
            int j = i;
            for (; j > 0 && array[j - 1] < tmp; j--) {
                //j为已经排好序的元素数量，后边需要对比
                //比较当前位置左侧所有已经排好序的数字，选择一个合适的位置插入，通过右移空出位置
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }

    }

    /**
     * 冒泡排序
     * 遍历数组两两进行比较，需要冒泡的次数为数组长度-1
     * 最差O(n^2) 最好的时间复杂度是 O(n) 取决去原数组的有序程度
     * 是稳定的排序算法
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int tmp;
        for (int i = 1; i < array.length; i++) {
            //每次冒泡都会冒出一个元素，i标识冒出元素的个数，为长度-1
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                //j标识每次冒出元素后，剩余元素的下表
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("退出了，i:" + i);
                break;
            }
        }

    }

    /**
     * 选择排序
     * 根据原数组的下标位置，每一次循环遍历剩下的数组
     * 选择出每个下标位置对应的最小数字，放到当前位置上
     * O(n^2) 不稳定排序，即内部循环不一定会走几次,即变量的赋值
     * 最好的时间复杂度是O(n) 即已经排好序的数组
     * @param array
     */
    public static void selectSort(int[] array) {
        int minValue = 0;
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            minValue = array[i];
            //i表示需要选择的次数，为长度-1，剩余未遍历的元素即为最小或者最大元素
            //即完成长度减1次循环即可
            for (int j = i; j < array.length; j++) {
                //j标识从哪个下标开始继续判断剩余数组的最小值
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            //如果经过遍历后发现最小元素的下标不是当前下标，则需要调换二者位置
            if (minIndex != i) {
                int tmp = 0;
                tmp = minValue;
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }
    }


}


