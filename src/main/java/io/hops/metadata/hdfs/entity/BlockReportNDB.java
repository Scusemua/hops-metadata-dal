package io.hops.metadata.hdfs.entity;

/**
 * Encapsulates entries in NDB for BlockReports.
 */
public class BlockReportNDB {
    private long blockId;
    private int blockIndex;
    private long inodeId;
    private long numBytes;
    private long generationStamp;
    private int blockUCState;
    private long timeStamp;

    private String base64EncodedBlockReport;

    public BlockReportNDB(long blockId, String base64EncodedBlockReport) {
        this.blockId = blockId;
        this.base64EncodedBlockReport = base64EncodedBlockReport;
    }

    public BlockReportNDB(long blockId, int blockIndex, long inodeId, long numBytes, long generationStamp, long timeStamp) {
        this.blockId = blockId;
        this.blockIndex = blockIndex;
        this.inodeId = inodeId;
        this.numBytes = numBytes;
        this.generationStamp = generationStamp;
        this.timeStamp = timeStamp;
    }
}
