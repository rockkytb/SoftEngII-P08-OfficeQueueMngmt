package com.SoftEngII_P08.fullstack.OfficeQueue.OfficeQueueMngmntFullStack.Repository;

public interface Ticket extends JpaRepository<int, Long> {

    Foo findByName(String name);

}