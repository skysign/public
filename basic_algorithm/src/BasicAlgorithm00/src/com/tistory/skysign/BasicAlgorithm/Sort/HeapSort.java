package com.tistory.skysign.BasicAlgorithm.Sort;

public class HeapSort extends SortBase {
    /*
    2차원 배열을 사용해서, 쉽게 바이너리 트리를 만들 수 있습니다.
    우선 배열의 0은 사용하지 않고, 1부터 사용합니다.
    이렇게 하면, 쉽게 바이너리 트리의 부모/자식 관계를 나타 낼 수 있습니다.

    1 : 루트
    1 * 2 + 0 = 2 : 루트의 왼쪽 자식 노드
    1 * 2 + 1 = 3 : 루트의 오른쪽 자식 노드

    2 * 2 + 0 = 4 : 2번 노드의 왼쪽 자식 노드
    2 * 2 + 1 = 5 : 2번 노드의 오른쪽 자식 노드

    이런식으로 하면,
    N * 2 + 0(or 1)을 사용해서, 바이너리 트리를 배열에 저장하는 것이 가능합니다.

    반대로 4번 노드의 부모는 2가 되며, 5번 노드의 부모도 2가 됩니다.
    4 / 2 = 2
    5 / 2 = 2
     */
    static public int Buf[] = new int[MAX+1];
    static public int NUM = 0;

    static public void HeapSort() {
        NUM = 0;

        /*
        upheap 함수에서 부모노드를 찾아 가면서
        부모/자식 노드를 스왑할 때, 1번 노드에서 무조건 멈추도록,
        배열 0번에 노드가 가질 수 있는 최대값을 지정합니다.

        0번 배열은 UpHeap함수의 while 루프는 부모가 자기 값보다 클 때 멈추게 됩니다.
        k 가 1일 때, 0번 배열과 비교함으로, 루프를 멈추는 마지막 조건이 됩니다.
        if문을 추가하여 k가 1일때, 멈추게 해도 같은 동작을 합니다.
         */
        Buf[0] = MAX + 1;

        for (int i=0; i<MAX; ++i)
            InsertData(mBuf[i]);

        for (int i=MAX -1; i>=0; --i)
            mBuf[i] = RemoveData();
    }

    static public int RemoveData() {
        int v = Buf[1];
        Buf[1] = Buf[NUM--];
        downheap(1);

        return v;
    }

    /*
    p318~319의 downheap()함수가 잘 이해가 가지 않아서,
    새로 작성해 봤습니다.
     */
    static void downheap(int k) {
        int i, v;
        v = Buf[k];

        while (k <= NUM / 2) {
            i = 2 * k;
            // 부모 k의 자식 i와 i+1과 비교합니다.

            // NUM 배열의 마지막 원소의 인덱스입니다.
            // i<NUM이 true이면, 배열은 i+1까지 존재 합니다.
            // 오른쪽 자식 노드가 없을 수도 있으므로, i<NUM 이 필요합니다
            if (i<NUM && Buf[i] < Buf[i+1])
                i++;
            // i는 두개의 자식 노드중 큰 자식 노드를 가리킴니다

            // 큰 자식 노드보다, v가 크기 때문에,
            // 더이상 downheap 하지 않고, break 합니다.
            if (v >= Buf[i])
                break;

            // Buf[k] 보다 더 큰 자식노드가 Buf[i] 입니다.
            Buf[k] = Buf[i];
            // Buf[i]를 위로 이동시킴니다.
            k = i;
        }

        // 현재 노드 k에 v를 저장합니다
        Buf[k] = v;
    }

    static public void InsertData(int v) {
        Buf[++NUM] = v;
        upheap(NUM);
    }

    static public void upheap(int k) {
        int v;
        v = Buf[k];

        while (Buf[k/2] <= v) {
            Buf[k] = Buf[k/2];
            k = k / 2;
        }

        Buf[k] = v;
    }

    static public void run() {
        makeRandomNumber();
        System.out.println("Input");
        DisplayBuffer();
        HeapSort();
        System.out.println("Result");
        DisplayBuffer();
    }
}
