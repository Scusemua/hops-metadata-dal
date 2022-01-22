package io.hops.metadata.hdfs.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * This interface defines the API through which DataNodes and NameNodes can read/write
 * BlockReport structures to NDB. This is used by the Serverless NameNode to obtain
 * BlockReports from NameNodes given the existing RPC implementation does not work in
 * a serverless context.
 */
public interface BlockReportDataAccess<T> extends EntityDataAccess {
    /**
     * Count the number of available BlockReport objects in NDB.
     * @return The number of BlockReports in NDB.
     * @throws StorageException
     */
    int countAll() throws StorageException;

    /**
     * Look for a given BlockReport by the ID of its corresponding block.
     * @param blockId The ID of the block associated with the given BlockReport.
     * @param inodeId The ID of the associated inode.
     * @return The BlockReport with the given ID, or null.
     * @throws StorageException
     */
    T findReportById(long blockId, long inodeId) throws StorageException;

    /**
     * Find one or more BlockReports by looking for the inode ID to which the block is associated.
     * @throws StorageException
     */
    List<T> findReportsByInodeId(long inodeId) throws StorageException;

    /**
     * Find one or more BlockReports by looking for the inode IDs to which the blocks are associated.
     * @throws StorageException
     */
    List<T> findReportsByInodeIds(long[] inodeIds) throws StorageException;

    /**
     * Retrieve all of the available Block Reports.
     * @throws StorageException
     */
    List<T> findAllBlockReports() throws StorageException;

    /**
     * Returns range of block reports with block IDs [StartID, endID)
     * @throws StorageException
     */
    List<T> findAllBlockReports(long startID, long endID) throws StorageException;

    /**
     * DataNodes have one or more storages. This finds block reports associated with a particular storage.
     * @throws StorageException
     */
    List<T> findBlockReportsByStorageId(int storageId) throws StorageException;

    List<T> findBlockReportsByStorageId(int storageId, long from, int size) throws StorageException;

    /**
     * Returns a list of all blocks stored on a set of storages.
     *
     * Beware; running this for a big datanode requires a lot of memory
     */
    List<T> findBlockInfosBySids(List<Integer> sids) throws StorageException;
}
