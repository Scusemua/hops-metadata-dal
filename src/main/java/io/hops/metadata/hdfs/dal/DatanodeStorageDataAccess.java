package io.hops.metadata.hdfs.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;

import java.util.List;

/**
 * Interface defining the API used to read and write DatanodeStorage objects to NDB.
 *
 * TODO: There already exists a {@link StorageDataAccess} class that essentially does exactly what this
 *       class does. So at some point I need to get rid of this class and just use the existing class.
 */
public interface DatanodeStorageDataAccess<T> extends EntityDataAccess {
    /**
     * Find and return the DatanodeStorage instance with the given storageId, associated with the
     * datanode identified by the given UUID, from NDB.
     */
    T getDatanodeStorage(String storageId, String datanodeUuid) throws StorageException;

    /**
     * Retrieve all DatanodeStorage instances associated with the datanode identified by the given UUID.
     * @param datanodeUuid The UUID of the desired data node.
     */
    List<T> getDatanodeStorages(String datanodeUuid) throws StorageException;

    /**
     * Find and remove/delete the DatanodeStorage instance with the given storageId.
     */
    void removeDatanodeStorage(String storageId, String datanodeUuid) throws StorageException;

    /**
     * Remove all DatanodeStorage instances associated with the datanode identified by the given UUID.
     *
     * @return The number of storage reports that were deleted.
     */
    int removeDatanodeStorages(String datanodeUuid) throws StorageException;

    /**
     * Store the given DatanodeStorage instance in NDB.
     * @param datanodeStorage The DatanodeStorage instance to store in NDB.
     */
    void addDatanodeStorage(T datanodeStorage) throws StorageException;
}
