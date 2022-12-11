package com.mozza.dddstart2kotlin.lock

interface LockManager {
    fun tryLock(type: String, id: String): LockId

    fun heckLock(lockId: LockId)

    fun releaseLock(lockId: LockId)

    fun extendLockExpiration(lodckId: LockId, inc: Long)
}